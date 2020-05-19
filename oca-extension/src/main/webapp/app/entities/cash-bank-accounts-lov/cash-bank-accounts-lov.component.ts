import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ICashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { CashBankAccountsLOVService } from './cash-bank-accounts-lov.service';
import { CashBankAccountsLOVDeleteDialogComponent } from './cash-bank-accounts-lov-delete-dialog.component';

@Component({
  selector: 'jhi-cash-bank-accounts-lov',
  templateUrl: './cash-bank-accounts-lov.component.html'
})
export class CashBankAccountsLOVComponent implements OnInit, OnDestroy {
  cashBankAccountsLOVS?: ICashBankAccountsLOV[];
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;

  constructor(
    protected cashBankAccountsLOVService: CashBankAccountsLOVService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadPage(page?: number): void {
    const pageToLoad: number = page || this.page;

    this.cashBankAccountsLOVService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<ICashBankAccountsLOV[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
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
    this.registerChangeInCashBankAccountsLOVS();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ICashBankAccountsLOV): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.bankAccountId!;
  }

  registerChangeInCashBankAccountsLOVS(): void {
    this.eventSubscriber = this.eventManager.subscribe('cashBankAccountsLOVListModification', () => this.loadPage());
  }

  delete(cashBankAccountsLOV: ICashBankAccountsLOV): void {
    const modalRef = this.modalService.open(CashBankAccountsLOVDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.cashBankAccountsLOV = cashBankAccountsLOV;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected onSuccess(data: ICashBankAccountsLOV[] | null, headers: HttpHeaders, page: number): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    this.router.navigate(['/cash-bank-accounts-lov'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc')
      }
    });
    this.cashBankAccountsLOVS = data || [];
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page;
  }
}
