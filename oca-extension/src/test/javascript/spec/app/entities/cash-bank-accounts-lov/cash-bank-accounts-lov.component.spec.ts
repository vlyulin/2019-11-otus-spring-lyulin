import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data } from '@angular/router';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBankAccountsLOVComponent } from 'app/entities/cash-bank-accounts-lov/cash-bank-accounts-lov.component';
import { CashBankAccountsLOVService } from 'app/entities/cash-bank-accounts-lov/cash-bank-accounts-lov.service';
import { CashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';

describe('Component Tests', () => {
  describe('CashBankAccountsLOV Management Component', () => {
    let comp: CashBankAccountsLOVComponent;
    let fixture: ComponentFixture<CashBankAccountsLOVComponent>;
    let service: CashBankAccountsLOVService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBankAccountsLOVComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: {
                subscribe: (fn: (value: Data) => void) =>
                  fn({
                    pagingParams: {
                      predicate: 'id',
                      reverse: false,
                      page: 0
                    }
                  })
              }
            }
          }
        ]
      })
        .overrideTemplate(CashBankAccountsLOVComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CashBankAccountsLOVComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CashBankAccountsLOVService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new CashBankAccountsLOV(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.cashBankAccountsLOVS && comp.cashBankAccountsLOVS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new CashBankAccountsLOV(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.cashBankAccountsLOVS && comp.cashBankAccountsLOVS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});
