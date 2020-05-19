import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICashBanksLOV, CashBanksLOV } from 'app/shared/model/cash-banks-lov.model';
import { CashBanksLOVService } from './cash-banks-lov.service';
import { CashBanksLOVComponent } from './cash-banks-lov.component';
import { CashBanksLOVDetailComponent } from './cash-banks-lov-detail.component';
import { CashBanksLOVUpdateComponent } from './cash-banks-lov-update.component';

@Injectable({ providedIn: 'root' })
export class CashBanksLOVResolve implements Resolve<ICashBanksLOV> {
  constructor(private service: CashBanksLOVService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICashBanksLOV> | Observable<never> {
    const id = route.params['bankPartyId'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((cashBanksLOV: HttpResponse<CashBanksLOV>) => {
          if (cashBanksLOV.body) {
            return of(cashBanksLOV.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CashBanksLOV());
  }
}

export const cashBanksLOVRoute: Routes = [
  {
    path: '',
    component: CashBanksLOVComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'CashBanksLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':bankPartyId/view',
    component: CashBanksLOVDetailComponent,
    resolve: {
      cashBanksLOV: CashBanksLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBanksLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CashBanksLOVUpdateComponent,
    resolve: {
      cashBanksLOV: CashBanksLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBanksLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':bankPartyId/edit',
    component: CashBanksLOVUpdateComponent,
    resolve: {
      cashBanksLOV: CashBanksLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBanksLOVS'
    },
    canActivate: [UserRouteAccessService]
  }
];
