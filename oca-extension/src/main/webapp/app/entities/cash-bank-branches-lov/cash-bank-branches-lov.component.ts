import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ICashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { CashBankBranchesLOVService } from './cash-bank-branches-lov.service';
import { CashBankBranchesLOVDeleteDialogComponent } from './cash-bank-branches-lov-delete-dialog.component';

@Component({
  selector: 'jhi-cash-bank-branches-lov',
  templateUrl: './cash-bank-branches-lov.component.html'
})
export class CashBankBranchesLOVComponent implements OnInit, OnDestroy {
  cashBankBranchesLOVS?: ICashBankBranchesLOV[];
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;

  constructor(
    protected cashBankBranchesLOVService: CashBankBranchesLOVService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadPage(page?: number): void {
    const pageToLoad: number = page || this.page;

    this.cashBankBranchesLOVService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<ICashBankBranchesLOV[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
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
    this.registerChangeInCashBankBranchesLOVS();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ICashBankBranchesLOV): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.branchPartyId!; // id
  }

  registerChangeInCashBankBranchesLOVS(): void {
    this.eventSubscriber = this.eventManager.subscribe('cashBankBranchesLOVListModification', () => this.loadPage());
  }

  delete(cashBankBranchesLOV: ICashBankBranchesLOV): void {
    const modalRef = this.modalService.open(CashBankBranchesLOVDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.cashBankBranchesLOV = cashBankBranchesLOV;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'BranchPartyId') { // 'id'
      result.push('BranchPartyId'); // 'id'
    }
    return result;
  }

  protected onSuccess(data: ICashBankBranchesLOV[] | null, headers: HttpHeaders, page: number): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    this.router.navigate(['/cash-bank-branches-lov'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc')
      }
    });
    this.cashBankBranchesLOVS = data || [];
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page;
  }
}
