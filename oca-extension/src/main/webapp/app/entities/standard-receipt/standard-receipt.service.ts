import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IStandardReceipt } from 'app/shared/model/standard-receipt.model';

type EntityResponseType = HttpResponse<IStandardReceipt>;
type EntityArrayResponseType = HttpResponse<IStandardReceipt[]>;

@Injectable({ providedIn: 'root' })
export class StandardReceiptService {
  public resourceUrl = SERVER_API_URL + 'api/standard-receipts';

  constructor(protected http: HttpClient) {}

  create(standardReceipt: IStandardReceipt): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(standardReceipt);
    return this.http
      .post<IStandardReceipt>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(standardReceipt: IStandardReceipt): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(standardReceipt);
    return this.http
      .put<IStandardReceipt>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IStandardReceipt>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {

    if(!req['q'] || req['q'] === undefined || req['q'] === "") {
      delete req['q'];
    }
    const options = createRequestOption(req);
    return this.http
      .get<IStandardReceipt[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(standardReceipt: IStandardReceipt): IStandardReceipt {
    const copy: IStandardReceipt = Object.assign({}, standardReceipt, {
      receiptDate:
        standardReceipt.receiptDate && standardReceipt.receiptDate.isValid() ? standardReceipt.receiptDate.format(DATE_FORMAT) : undefined,
      conversionDate:
        standardReceipt.conversionDate && standardReceipt.conversionDate.isValid()
          ? standardReceipt.conversionDate.format(DATE_FORMAT)
          : undefined,
      remittanceBankDepositDate:
        standardReceipt.remittanceBankDepositDate && standardReceipt.remittanceBankDepositDate.isValid()
          ? standardReceipt.remittanceBankDepositDate.format(DATE_FORMAT)
          : undefined,
      accountingDate:
        standardReceipt.accountingDate && standardReceipt.accountingDate.isValid()
          ? standardReceipt.accountingDate.format(DATE_FORMAT)
          : undefined,
      maturityDate:
        standardReceipt.maturityDate && standardReceipt.maturityDate.isValid()
          ? standardReceipt.maturityDate.format(DATE_FORMAT)
          : undefined,
      postmarkDate:
        standardReceipt.postmarkDate && standardReceipt.postmarkDate.isValid()
          ? standardReceipt.postmarkDate.format(DATE_FORMAT)
          : undefined,
      creationDate:
        standardReceipt.creationDate && standardReceipt.creationDate.isValid()
          ? standardReceipt.creationDate.format(DATE_FORMAT)
          : undefined,
      lastUpdateDate:
        standardReceipt.lastUpdateDate && standardReceipt.lastUpdateDate.isValid()
          ? standardReceipt.lastUpdateDate.format(DATE_FORMAT)
          : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.receiptDate = res.body.receiptDate ? moment(res.body.receiptDate) : undefined;
      res.body.conversionDate = res.body.conversionDate ? moment(res.body.conversionDate) : undefined;
      res.body.remittanceBankDepositDate = res.body.remittanceBankDepositDate ? moment(res.body.remittanceBankDepositDate) : undefined;
      res.body.accountingDate = res.body.accountingDate ? moment(res.body.accountingDate) : undefined;
      res.body.maturityDate = res.body.maturityDate ? moment(res.body.maturityDate) : undefined;
      res.body.postmarkDate = res.body.postmarkDate ? moment(res.body.postmarkDate) : undefined;
      res.body.creationDate = res.body.creationDate ? moment(res.body.creationDate) : undefined;
      res.body.lastUpdateDate = res.body.lastUpdateDate ? moment(res.body.lastUpdateDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((standardReceipt: IStandardReceipt) => {
        standardReceipt.receiptDate = standardReceipt.receiptDate ? moment(standardReceipt.receiptDate) : undefined;
        standardReceipt.conversionDate = standardReceipt.conversionDate ? moment(standardReceipt.conversionDate) : undefined;
        standardReceipt.remittanceBankDepositDate = standardReceipt.remittanceBankDepositDate
          ? moment(standardReceipt.remittanceBankDepositDate)
          : undefined;
        standardReceipt.accountingDate = standardReceipt.accountingDate ? moment(standardReceipt.accountingDate) : undefined;
        standardReceipt.maturityDate = standardReceipt.maturityDate ? moment(standardReceipt.maturityDate) : undefined;
        standardReceipt.postmarkDate = standardReceipt.postmarkDate ? moment(standardReceipt.postmarkDate) : undefined;
        standardReceipt.creationDate = standardReceipt.creationDate ? moment(standardReceipt.creationDate) : undefined;
        standardReceipt.lastUpdateDate = standardReceipt.lastUpdateDate ? moment(standardReceipt.lastUpdateDate) : undefined;
      });
    }
    return res;
  }
}
