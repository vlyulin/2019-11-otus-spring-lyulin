import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ICustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { CustomerAccountSitesLOVService } from './customer-account-sites-lov.service';
import { CustomerAccountSitesLOVDeleteDialogComponent } from './customer-account-sites-lov-delete-dialog.component';

@Component({
  selector: 'jhi-customer-account-sites-lov',
  templateUrl: './customer-account-sites-lov.component.html'
})
export class CustomerAccountSitesLOVComponent implements OnInit, OnDestroy {
  customerAccountSitesLOVS?: ICustomerAccountSitesLOV[];
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;

  constructor(
    protected customerAccountSitesLOVService: CustomerAccountSitesLOVService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadPage(page?: number): void {
    const pageToLoad: number = page || this.page;

    this.customerAccountSitesLOVService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<ICustomerAccountSitesLOV[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
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
    this.registerChangeInCustomerAccountSitesLOVS();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ICustomerAccountSitesLOV): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.siteUseId!;
  }

  registerChangeInCustomerAccountSitesLOVS(): void {
    this.eventSubscriber = this.eventManager.subscribe('customerAccountSitesLOVListModification', () => this.loadPage());
  }

  delete(customerAccountSitesLOV: ICustomerAccountSitesLOV): void {
    const modalRef = this.modalService.open(CustomerAccountSitesLOVDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.customerAccountSitesLOV = customerAccountSitesLOV;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected onSuccess(data: ICustomerAccountSitesLOV[] | null, headers: HttpHeaders, page: number): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    this.router.navigate(['/customer-account-sites-lov'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc')
      }
    });
    this.customerAccountSitesLOVS = data || [];
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page;
  }
}
