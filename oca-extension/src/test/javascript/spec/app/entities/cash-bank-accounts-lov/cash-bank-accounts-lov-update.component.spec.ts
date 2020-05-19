import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBankAccountsLOVUpdateComponent } from 'app/entities/cash-bank-accounts-lov/cash-bank-accounts-lov-update.component';
import { CashBankAccountsLOVService } from 'app/entities/cash-bank-accounts-lov/cash-bank-accounts-lov.service';
import { CashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';

describe('Component Tests', () => {
  describe('CashBankAccountsLOV Management Update Component', () => {
    let comp: CashBankAccountsLOVUpdateComponent;
    let fixture: ComponentFixture<CashBankAccountsLOVUpdateComponent>;
    let service: CashBankAccountsLOVService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBankAccountsLOVUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CashBankAccountsLOVUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CashBankAccountsLOVUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CashBankAccountsLOVService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CashBankAccountsLOV(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new CashBankAccountsLOV();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
