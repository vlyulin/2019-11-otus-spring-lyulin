import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBankBranchesLOVUpdateComponent } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov-update.component';
import { CashBankBranchesLOVService } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov.service';
import { CashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';

describe('Component Tests', () => {
  describe('CashBankBranchesLOV Management Update Component', () => {
    let comp: CashBankBranchesLOVUpdateComponent;
    let fixture: ComponentFixture<CashBankBranchesLOVUpdateComponent>;
    let service: CashBankBranchesLOVService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBankBranchesLOVUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CashBankBranchesLOVUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CashBankBranchesLOVUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CashBankBranchesLOVService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CashBankBranchesLOV(123);
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
        const entity = new CashBankBranchesLOV();
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
