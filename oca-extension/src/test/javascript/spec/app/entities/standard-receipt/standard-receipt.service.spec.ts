import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { StandardReceiptService } from 'app/entities/standard-receipt/standard-receipt.service';
import { IStandardReceipt, StandardReceipt } from 'app/shared/model/standard-receipt.model';

describe('Service Tests', () => {
  describe('StandardReceipt Service', () => {
    let injector: TestBed;
    let service: StandardReceiptService;
    let httpMock: HttpTestingController;
    let elemDefault: IStandardReceipt;
    let expectedResult: IStandardReceipt | IStandardReceipt[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(StandardReceiptService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new StandardReceipt(
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            receiptDate: currentDate.format(DATE_FORMAT),
            conversionDate: currentDate.format(DATE_FORMAT),
            remittanceBankDepositDate: currentDate.format(DATE_FORMAT),
            accountingDate: currentDate.format(DATE_FORMAT),
            maturityDate: currentDate.format(DATE_FORMAT),
            postmarkDate: currentDate.format(DATE_FORMAT),
            creationDate: currentDate.format(DATE_FORMAT),
            lastUpdateDate: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a StandardReceipt', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            receiptDate: currentDate.format(DATE_FORMAT),
            conversionDate: currentDate.format(DATE_FORMAT),
            remittanceBankDepositDate: currentDate.format(DATE_FORMAT),
            accountingDate: currentDate.format(DATE_FORMAT),
            maturityDate: currentDate.format(DATE_FORMAT),
            postmarkDate: currentDate.format(DATE_FORMAT),
            creationDate: currentDate.format(DATE_FORMAT),
            lastUpdateDate: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            receiptDate: currentDate,
            conversionDate: currentDate,
            remittanceBankDepositDate: currentDate,
            accountingDate: currentDate,
            maturityDate: currentDate,
            postmarkDate: currentDate,
            creationDate: currentDate,
            lastUpdateDate: currentDate
          },
          returnedFromService
        );

        service.create(new StandardReceipt()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a StandardReceipt', () => {
        const returnedFromService = Object.assign(
          {
            standardReceiptId: 1,
            receiptNumber: 'BBBBBB',
            businessUnit: 'BBBBBB',
            receiptMethod: 'BBBBBB',
            receiptDate: currentDate.format(DATE_FORMAT),
            documentNumber: 1,
            amount: 1,
            currency: 'BBBBBB',
            conversionRateType: 'BBBBBB',
            conversionDate: currentDate.format(DATE_FORMAT),
            conversionRate: 1,
            state: 'BBBBBB',
            status: 'BBBBBB',
            remittanceBankName: 'BBBBBB',
            remittanceBankBranch: 'BBBBBB',
            remittanceBankAccountNumber: 'BBBBBB',
            remittanceBankDepositDate: currentDate.format(DATE_FORMAT),
            remittanceBankAllowOverride: 'BBBBBB',
            customerName: 'BBBBBB',
            taxpayerIdentificationNumber: 'BBBBBB',
            customerSite: 'BBBBBB',
            customerAccountNumber: 'BBBBBB',
            customerBank: 'BBBBBB',
            customerBankBranch: 'BBBBBB',
            customerBankAccountNumber: 'BBBBBB',
            unappliedAmount: 1,
            accountedAmount: 1,
            accountingDate: currentDate.format(DATE_FORMAT),
            maturityDate: currentDate.format(DATE_FORMAT),
            postmarkDate: currentDate.format(DATE_FORMAT),
            receiptAtRisk: 'BBBBBB',
            receivablesSpecialist: 'BBBBBB',
            comments: 'BBBBBB',
            creditCardTokenNumber: 'BBBBBB',
            creditCardAuthorizationRequestIdentifier: 1,
            cardHolderFirstName: 'BBBBBB',
            cardHolderLastName: 'BBBBBB',
            creditCardIssuerCode: 'BBBBBB',
            creditCardExpirationDate: 'BBBBBB',
            voiceAuthorizationCode: 'BBBBBB',
            createdBy: 'BBBBBB',
            creationDate: currentDate.format(DATE_FORMAT),
            lastUpdateDate: currentDate.format(DATE_FORMAT),
            lastUpdatedBy: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            receiptDate: currentDate,
            conversionDate: currentDate,
            remittanceBankDepositDate: currentDate,
            accountingDate: currentDate,
            maturityDate: currentDate,
            postmarkDate: currentDate,
            creationDate: currentDate,
            lastUpdateDate: currentDate
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of StandardReceipt', () => {
        const returnedFromService = Object.assign(
          {
            standardReceiptId: 1,
            receiptNumber: 'BBBBBB',
            businessUnit: 'BBBBBB',
            receiptMethod: 'BBBBBB',
            receiptDate: currentDate.format(DATE_FORMAT),
            documentNumber: 1,
            amount: 1,
            currency: 'BBBBBB',
            conversionRateType: 'BBBBBB',
            conversionDate: currentDate.format(DATE_FORMAT),
            conversionRate: 1,
            state: 'BBBBBB',
            status: 'BBBBBB',
            remittanceBankName: 'BBBBBB',
            remittanceBankBranch: 'BBBBBB',
            remittanceBankAccountNumber: 'BBBBBB',
            remittanceBankDepositDate: currentDate.format(DATE_FORMAT),
            remittanceBankAllowOverride: 'BBBBBB',
            customerName: 'BBBBBB',
            taxpayerIdentificationNumber: 'BBBBBB',
            customerSite: 'BBBBBB',
            customerAccountNumber: 'BBBBBB',
            customerBank: 'BBBBBB',
            customerBankBranch: 'BBBBBB',
            customerBankAccountNumber: 'BBBBBB',
            unappliedAmount: 1,
            accountedAmount: 1,
            accountingDate: currentDate.format(DATE_FORMAT),
            maturityDate: currentDate.format(DATE_FORMAT),
            postmarkDate: currentDate.format(DATE_FORMAT),
            receiptAtRisk: 'BBBBBB',
            receivablesSpecialist: 'BBBBBB',
            comments: 'BBBBBB',
            creditCardTokenNumber: 'BBBBBB',
            creditCardAuthorizationRequestIdentifier: 1,
            cardHolderFirstName: 'BBBBBB',
            cardHolderLastName: 'BBBBBB',
            creditCardIssuerCode: 'BBBBBB',
            creditCardExpirationDate: 'BBBBBB',
            voiceAuthorizationCode: 'BBBBBB',
            createdBy: 'BBBBBB',
            creationDate: currentDate.format(DATE_FORMAT),
            lastUpdateDate: currentDate.format(DATE_FORMAT),
            lastUpdatedBy: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            receiptDate: currentDate,
            conversionDate: currentDate,
            remittanceBankDepositDate: currentDate,
            accountingDate: currentDate,
            maturityDate: currentDate,
            postmarkDate: currentDate,
            creationDate: currentDate,
            lastUpdateDate: currentDate
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a StandardReceipt', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
