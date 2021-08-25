import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBankBranchesLOVDetailComponent } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov-detail.component';
import { CashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';

describe('Component Tests', () => {
  describe('CashBankBranchesLOV Management Detail Component', () => {
    let comp: CashBankBranchesLOVDetailComponent;
    let fixture: ComponentFixture<CashBankBranchesLOVDetailComponent>;
    const route = ({ data: of({ cashBankBranchesLOV: new CashBankBranchesLOV(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBankBranchesLOVDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CashBankBranchesLOVDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CashBankBranchesLOVDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load cashBankBranchesLOV on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cashBankBranchesLOV).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
