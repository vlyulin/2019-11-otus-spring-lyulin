import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';

type EntityResponseType = HttpResponse<ICustomerAccountSitesLOV>;
type EntityArrayResponseType = HttpResponse<ICustomerAccountSitesLOV[]>;

@Injectable({ providedIn: 'root' })
export class CustomerAccountSitesLOVService {
  public resourceUrl = SERVER_API_URL + 'api/customer-account-sites-lovs';

  constructor(protected http: HttpClient) {}

  create(customerAccountSitesLOV: ICustomerAccountSitesLOV): Observable<EntityResponseType> {
    return this.http.post<ICustomerAccountSitesLOV>(this.resourceUrl, customerAccountSitesLOV, { observe: 'response' });
  }

  update(customerAccountSitesLOV: ICustomerAccountSitesLOV): Observable<EntityResponseType> {
    return this.http.put<ICustomerAccountSitesLOV>(this.resourceUrl, customerAccountSitesLOV, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICustomerAccountSitesLOV>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICustomerAccountSitesLOV[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
