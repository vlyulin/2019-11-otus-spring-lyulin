import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBanksLOVDetailComponent } from 'app/entities/cash-banks-lov/cash-banks-lov-detail.component';
import { CashBanksLOV } from 'app/shared/model/cash-banks-lov.model';

describe('Component Tests', () => {
  describe('CashBanksLOV Management Detail Component', () => {
    let comp: CashBanksLOVDetailComponent;
    let fixture: ComponentFixture<CashBanksLOVDetailComponent>;
    const route = ({ data: of({ cashBanksLOV: new CashBanksLOV(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBanksLOVDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CashBanksLOVDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CashBanksLOVDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load cashBanksLOV on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cashBanksLOV).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
