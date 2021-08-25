import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data } from '@angular/router';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBanksLOVComponent } from 'app/entities/cash-banks-lov/cash-banks-lov.component';
import { CashBanksLOVService } from 'app/entities/cash-banks-lov/cash-banks-lov.service';
import { CashBanksLOV } from 'app/shared/model/cash-banks-lov.model';

describe('Component Tests', () => {
  describe('CashBanksLOV Management Component', () => {
    let comp: CashBanksLOVComponent;
    let fixture: ComponentFixture<CashBanksLOVComponent>;
    let service: CashBanksLOVService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBanksLOVComponent],
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
        .overrideTemplate(CashBanksLOVComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CashBanksLOVComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CashBanksLOVService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new CashBanksLOV(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.cashBanksLOVS && comp.cashBanksLOVS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new CashBanksLOV(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.cashBanksLOVS && comp.cashBanksLOVS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
