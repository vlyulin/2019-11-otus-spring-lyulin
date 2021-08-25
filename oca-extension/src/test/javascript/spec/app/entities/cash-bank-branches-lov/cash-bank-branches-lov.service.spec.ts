import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CashBankBranchesLOVService } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov.service';
import { ICashBankBranchesLOV, CashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';

describe('Service Tests', () => {
  describe('CashBankBranchesLOV Service', () => {
    let injector: TestBed;
    let service: CashBankBranchesLOVService;
    let httpMock: HttpTestingController;
    let elemDefault: ICashBankBranchesLOV;
    let expectedResult: ICashBankBranchesLOV | ICashBankBranchesLOV[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(CashBankBranchesLOVService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new CashBankBranchesLOV(0, 0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a CashBankBranchesLOV', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new CashBankBranchesLOV()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a CashBankBranchesLOV', () => {
        const returnedFromService = Object.assign(
          {
            branchPartyId: 1,
            bankBranchName: 'BBBBBB',
            branchNumber: 'BBBBBB',
            bankName: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of CashBankBranchesLOV', () => {
        const returnedFromService = Object.assign(
          {
            branchPartyId: 1,
            bankBranchName: 'BBBBBB',
            branchNumber: 'BBBBBB',
            bankName: 'BBBBBB'
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

      it('should delete a CashBankBranchesLOV', () => {
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
