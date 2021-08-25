import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICashBankBranchesLOV, CashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';
import { CashBankBranchesLOVService } from './cash-bank-branches-lov.service';
import { CashBankBranchesLOVComponent } from './cash-bank-branches-lov.component';
import { CashBankBranchesLOVDetailComponent } from './cash-bank-branches-lov-detail.component';
import { CashBankBranchesLOVUpdateComponent } from './cash-bank-branches-lov-update.component';

@Injectable({ providedIn: 'root' })
export class CashBankBranchesLOVResolve implements Resolve<ICashBankBranchesLOV> {
  constructor(private service: CashBankBranchesLOVService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICashBankBranchesLOV> | Observable<never> {
    const id = route.params['branchPartyId'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((cashBankBranchesLOV: HttpResponse<CashBankBranchesLOV>) => {
          if (cashBankBranchesLOV.body) {
            return of(cashBankBranchesLOV.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CashBankBranchesLOV());
  }
}

export const cashBankBranchesLOVRoute: Routes = [
  {
    path: '',
    component: CashBankBranchesLOVComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'CashBankBranchesLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':branchPartyId/view', // ':id'
    component: CashBankBranchesLOVDetailComponent,
    resolve: {
      cashBankBranchesLOV: CashBankBranchesLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBankBranchesLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: CashBankBranchesLOVUpdateComponent,
    resolve: {
      cashBankBranchesLOV: CashBankBranchesLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBankBranchesLOVS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':branchPartyId/edit',
    component: CashBankBranchesLOVUpdateComponent,
    resolve: {
      cashBankBranchesLOV: CashBankBranchesLOVResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CashBankBranchesLOVS'
    },
    canActivate: [UserRouteAccessService]
  }
];
