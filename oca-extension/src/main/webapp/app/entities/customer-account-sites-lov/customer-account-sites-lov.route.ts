import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICustomerAccountSitesLOV, CustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';
import { CustomerAccountSitesLOVService } from './customer-account-sites-lov.service';
import { CustomerAccountSitesLOVComponent } from './customer-account-sites-lov.component';
import { CustomerAccountSitesLOVDetailComponent } from './customer-account-sites-lov-detail.component';
import { CustomerAccountSitesLOVUpdateComponent } from './customer-account-sites-lov-update.component';

@Injectable({ providedIn: 'root' })
export class CustomerAccountSitesLOVResolve implements Resolve<ICustomerAccountSitesLOV> {
  constructor(private service: CustomerAccountSitesLOVService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICustomerAccountSitesLOV> | Observable<never> {
    const id = route.params['siteUseId'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((customerAccountSitesLOV: HttpResponse<CustomerAccountSitesLOV>) => {
          if (customerAccountSitesLOV.body) {
            return of(customerAccountSitesLOV.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CustomerAccountSitesLOV());
  }
}

export const customerAccountSitesLOVRoute: Routes = [
  {
    path: '',
    component: CustomerAccountSitesLOVComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'CustomerAccountSitesLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':siteUseId/view',
    component: CustomerAccountSitesLOVDetailComponent,
    resolve: {
      customerAccountSitesLOV: CustomerAccountSitesLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CustomerAccountSitesLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CustomerAccountSitesLOVUpdateComponent,
    resolve: {
      customerAccountSitesLOV: CustomerAccountSitesLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CustomerAccountSitesLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':siteUseId/edit',
    component: CustomerAccountSitesLOVUpdateComponent,
    resolve: {
      customerAccountSitesLOV: CustomerAccountSitesLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CustomerAccountSitesLOVS'
    },
    canActivate: [UserRouteAccessService]
  }
];
