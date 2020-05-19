import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';

@Component({
  selector: 'jhi-customer-account-sites-lov-detail',
  templateUrl: './customer-account-sites-lov-detail.component.html'
})
export class CustomerAccountSitesLOVDetailComponent implements OnInit {
  customerAccountSitesLOV: ICustomerAccountSitesLOV | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ customerAccountSitesLOV }) => (this.customerAccountSitesLOV = customerAccountSitesLOV));
  }

  previousState(): void {
    window.history.back();
  }
}
