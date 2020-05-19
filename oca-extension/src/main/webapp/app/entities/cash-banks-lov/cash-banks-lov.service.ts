import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICashBanksLOV } from 'app/shared/model/cash-banks-lov.model';

type EntityResponseType = HttpResponse<ICashBanksLOV>;
type EntityArrayResponseType = HttpResponse<ICashBanksLOV[]>;

@Injectable({ providedIn: 'root' })
export class CashBanksLOVService {
  public resourceUrl = SERVER_API_URL + 'api/cash-banks-lovs';

  constructor(protected http: HttpClient) {}

  create(cashBanksLOV: ICashBanksLOV): Observable<EntityResponseType> {
    return this.http.post<ICashBanksLOV>(this.resourceUrl, cashBanksLOV, { observe: 'response' });
  }

  update(cashBanksLOV: ICashBanksLOV): Observable<EntityResponseType> {
    return this.http.put<ICashBanksLOV>(this.resourceUrl, cashBanksLOV, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICashBanksLOV>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICashBanksLOV[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
