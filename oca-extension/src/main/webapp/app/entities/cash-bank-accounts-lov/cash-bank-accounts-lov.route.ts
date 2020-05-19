import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICashBankAccountsLOV, CashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';
import { CashBankAccountsLOVService } from './cash-bank-accounts-lov.service';
import { CashBankAccountsLOVComponent } from './cash-bank-accounts-lov.component';
import { CashBankAccountsLOVDetailComponent } from './cash-bank-accounts-lov-detail.component';
import { CashBankAccountsLOVUpdateComponent } from './cash-bank-accounts-lov-update.component';

@Injectable({ providedIn: 'root' })
export class CashBankAccountsLOVResolve implements Resolve<ICashBankAccountsLOV> {
  constructor(private service: CashBankAccountsLOVService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICashBankAccountsLOV> | Observable<never> {
    const id = route.params['bankAccountId'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((cashBankAccountsLOV: HttpResponse<CashBankAccountsLOV>) => {
          if (cashBankAccountsLOV.body) {
            return of(cashBankAccountsLOV.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CashBankAccountsLOV());
  }
}

export const cashBankAccountsLOVRoute: Routes = [
  {
    path: '',
    component: CashBankAccountsLOVComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'CashBankAccountsLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':bankAccountId/view',
    component: CashBankAccountsLOVDetailComponent,
    resolve: {
      cashBankAccountsLOV: CashBankAccountsLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBankAccountsLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CashBankAccountsLOVUpdateComponent,
    resolve: {
      cashBankAccountsLOV: CashBankAccountsLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBankAccountsLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':bankAccountId/edit',
    component: CashBankAccountsLOVUpdateComponent,
    resolve: {
      cashBankAccountsLOV: CashBankAccountsLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBankAccountsLOVS'
    },
    canActivate: [UserRouteAccessService]
  }
];
