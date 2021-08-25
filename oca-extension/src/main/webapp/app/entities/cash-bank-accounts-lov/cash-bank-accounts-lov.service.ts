import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';

type EntityResponseType = HttpResponse<ICashBankAccountsLOV>;
type EntityArrayResponseType = HttpResponse<ICashBankAccountsLOV[]>;

@Injectable({ providedIn: 'root' })
export class CashBankAccountsLOVService {
  public resourceUrl = SERVER_API_URL + 'api/cash-bank-accounts-lovs';

  constructor(protected http: HttpClient) {}

  create(cashBankAccountsLOV: ICashBankAccountsLOV): Observable<EntityResponseType> {
    return this.http.post<ICashBankAccountsLOV>(this.resourceUrl, cashBankAccountsLOV, { observe: 'response' });
  }

  update(cashBankAccountsLOV: ICashBankAccountsLOV): Observable<EntityResponseType> {
    return this.http.put<ICashBankAccountsLOV>(this.resourceUrl, cashBankAccountsLOV, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICashBankAccountsLOV>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICashBankAccountsLOV[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
