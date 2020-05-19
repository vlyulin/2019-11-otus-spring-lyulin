import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';

type EntityResponseType = HttpResponse<ICashBankBranchesLOV>;
type EntityArrayResponseType = HttpResponse<ICashBankBranchesLOV[]>;

@Injectable({ providedIn: 'root' })
export class CashBankBranchesLOVService {
  public resourceUrl = SERVER_API_URL + 'api/cash-bank-branches-lovs';

  constructor(protected http: HttpClient) {}

  create(cashBankBranchesLOV: ICashBankBranchesLOV): Observable<EntityResponseType> {
    return this.http.post<ICashBankBranchesLOV>(this.resourceUrl, cashBankBranchesLOV, { observe: 'response' });
  }

  update(cashBankBranchesLOV: ICashBankBranchesLOV): Observable<EntityResponseType> {
    return this.http.put<ICashBankBranchesLOV>(this.resourceUrl, cashBankBranchesLOV, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICashBankBranchesLOV>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICashBankBranchesLOV[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
