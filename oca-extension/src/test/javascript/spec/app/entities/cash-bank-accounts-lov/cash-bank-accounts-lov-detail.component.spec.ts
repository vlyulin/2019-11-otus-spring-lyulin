import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBankAccountsLOVDetailComponent } from 'app/entities/cash-bank-accounts-lov/cash-bank-accounts-lov-detail.component';
import { CashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';

describe('Component Tests', () => {
  describe('CashBankAccountsLOV Management Detail Component', () => {
    let comp: CashBankAccountsLOVDetailComponent;
    let fixture: ComponentFixture<CashBankAccountsLOVDetailComponent>;
    const route = ({ data: of({ cashBankAccountsLOV: new CashBankAccountsLOV(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBankAccountsLOVDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CashBankAccountsLOVDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CashBankAccountsLOVDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load cashBankAccountsLOV on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cashBankAccountsLOV).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
