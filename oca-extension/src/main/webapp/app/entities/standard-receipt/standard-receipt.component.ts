import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder } from '@angular/forms';

import { IStandardReceipt } from 'app/shared/model/standard-receipt.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { StandardReceiptService } from './standard-receipt.service';
import { StandardReceiptDeleteDialogComponent } from './standard-receipt-delete-dialog.component';

@Component({
  selector: 'jhi-standard-receipt',
  templateUrl: './standard-receipt.component.html'
})
export class StandardReceiptComponent implements OnInit, OnDestroy {
  standardReceipts?: IStandardReceipt[];
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  filter = "";
  ngbPaginationPage = 1;

  // VL
  queryForm = this.fb.group({
    q: []
  })

  constructor(
    protected standardReceiptService: StandardReceiptService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    private fb: FormBuilder // VL
  ) {}

  loadPage(page?: number): void {
    const pageToLoad: number = page || this.page;

    this.standardReceiptService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
        q: this.filter // VL
      })
      .subscribe(
        (res: HttpResponse<IStandardReceipt[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
        () => this.onError()
      );
  }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(data => {
      this.page = data.pagingParams.page;
      this.ascending = data.pagingParams.ascending;
      this.predicate = data.pagingParams.predicate;
      this.ngbPaginationPage = data.pagingParams.page;
      this.loadPage();
    });
    this.registerChangeInStandardReceipts();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IStandardReceipt): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.standardReceiptId!;
  }

  registerChangeInStandardReceipts(): void {
    this.eventSubscriber = this.eventManager.subscribe('standardReceiptListModification', () => this.loadPage());
  }

  delete(standardReceipt: IStandardReceipt): void {
    const modalRef = this.modalService.open(StandardReceiptDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.standardReceipt = standardReceipt;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected onSuccess(data: IStandardReceipt[] | null, headers: HttpHeaders, page: number): void {

    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    this.router.navigate(['/standard-receipt'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc'),
        q: this.filter // VL 
      }
    });
    this.standardReceipts = data || [];
  }

  // VL
  find(): void {    
    this.filter = this.queryForm.get(['q'])!.value;
    console.warn('XXX find this.filter: ' + this.filter);
    
    this.page = 1;
    this.standardReceiptService
      .query({
        page: 1,
        size: this.itemsPerPage,
        sort: this.sort(),
        q: this.filter
      })
      .subscribe(
        (res: HttpResponse<IStandardReceipt[]>) => this.onSuccess(res.body, res.headers, this.page),
        () => this.onError()
      );
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page;
  }
}
