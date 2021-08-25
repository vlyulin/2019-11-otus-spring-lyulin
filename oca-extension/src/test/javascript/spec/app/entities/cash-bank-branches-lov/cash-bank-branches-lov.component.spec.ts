import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data } from '@angular/router';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBankBranchesLOVComponent } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov.component';
import { CashBankBranchesLOVService } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov.service';
import { CashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';

describe('Component Tests', () => {
  describe('CashBankBranchesLOV Management Component', () => {
    let comp: CashBankBranchesLOVComponent;
    let fixture: ComponentFixture<CashBankBranchesLOVComponent>;
    let service: CashBankBranchesLOVService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBankBranchesLOVComponent],
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
        .overrideTemplate(CashBankBranchesLOVComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CashBankBranchesLOVComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CashBankBranchesLOVService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new CashBankBranchesLOV(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.cashBankBranchesLOVS && comp.cashBankBranchesLOVS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new CashBankBranchesLOV(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.cashBankBranchesLOVS && comp.cashBankBranchesLOVS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
