import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CashBanksLOVService } from 'app/entities/cash-banks-lov/cash-banks-lov.service';
import { ICashBanksLOV, CashBanksLOV } from 'app/shared/model/cash-banks-lov.model';

describe('Service Tests', () => {
  describe('CashBanksLOV Service', () => {
    let injector: TestBed;
    let service: CashBanksLOVService;
    let httpMock: HttpTestingController;
    let elemDefault: ICashBanksLOV;
    let expectedResult: ICashBanksLOV | ICashBanksLOV[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(CashBanksLOVService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new CashBanksLOV(0, 'AAAAAAA', 'AAAAAAA', 0);
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a CashBanksLOV', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new CashBanksLOV()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a CashBanksLOV', () => {
        const returnedFromService = Object.assign(
          {
            bankName: 'BBBBBB',
            bankNumber: 'BBBBBB',
            bankPartyId: 1
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of CashBanksLOV', () => {
        const returnedFromService = Object.assign(
          {
            bankName: 'BBBBBB',
            bankNumber: 'BBBBBB',
            bankPartyId: 1
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a CashBanksLOV', () => {
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
