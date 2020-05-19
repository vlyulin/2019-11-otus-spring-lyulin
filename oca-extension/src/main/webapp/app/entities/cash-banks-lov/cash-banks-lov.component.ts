import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ICashBanksLOV } from 'app/shared/model/cash-banks-lov.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { CashBanksLOVService } from './cash-banks-lov.service';
import { CashBanksLOVDeleteDialogComponent } from './cash-banks-lov-delete-dialog.component';

@Component({
  selector: 'jhi-cash-banks-lov',
  templateUrl: './cash-banks-lov.component.html'
})
export class CashBanksLOVComponent implements OnInit, OnDestroy {
  cashBanksLOVS?: ICashBanksLOV[];
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;

  constructor(
    protected cashBanksLOVService: CashBanksLOVService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadPage(page?: number): void {
    const pageToLoad: number = page || this.page;

    this.cashBanksLOVService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<ICashBanksLOV[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
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
    this.registerChangeInCashBanksLOVS();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ICashBanksLOV): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.bankPartyId!; // id
  }

  registerChangeInCashBanksLOVS(): void {
    this.eventSubscriber = this.eventManager.subscribe('cashBanksLOVListModification', () => this.loadPage());
  }

  delete(cashBanksLOV: ICashBanksLOV): void {
    const modalRef = this.modalService.open(CashBanksLOVDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.cashBanksLOV = cashBanksLOV;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'bankPartyId') { // 'id'
      result.push('bankPartyId'); // 'id'
    }
    return result;
  }

  protected onSuccess(data: ICashBanksLOV[] | null, headers: HttpHeaders, page: number): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    this.router.navigate(['/cash-banks-lov'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc')
      }
    });
    this.cashBanksLOVS = data || [];
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page;
  }
}
