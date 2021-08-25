import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IStandardReceipt, StandardReceipt } from 'app/shared/model/standard-receipt.model';
import { StandardReceiptService } from './standard-receipt.service';
import { StandardReceiptComponent } from './standard-receipt.component';
import { StandardReceiptDetailComponent } from './standard-receipt-detail.component';
import { StandardReceiptUpdateComponent } from './standard-receipt-update.component';

@Injectable({ providedIn: 'root' })
export class StandardReceiptResolve implements Resolve<IStandardReceipt> {
  constructor(private service: StandardReceiptService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IStandardReceipt> | Observable<never> {
    const id = route.params['standardReceiptId'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((standardReceipt: HttpResponse<StandardReceipt>) => {
          if (standardReceipt.body) {
            return of(standardReceipt.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new StandardReceipt());
  }
}

export const standardReceiptRoute: Routes = [
  {
    path: '',
    component: StandardReceiptComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'StandardReceipts'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':standardReceiptId/view',
    component: StandardReceiptDetailComponent,
    resolve: {
      standardReceipt: StandardReceiptResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StandardReceipts'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: StandardReceiptUpdateComponent,
    resolve: {
      standardReceipt: StandardReceiptResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StandardReceipts'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':standardReceiptId/edit',
    component: StandardReceiptUpdateComponent,
    resolve: {
      standardReceipt: StandardReceiptResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StandardReceipts'
    },
    canActivate: [UserRouteAccessService]
  }
];
