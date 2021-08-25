import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CashBanksLOVUpdateComponent } from 'app/entities/cash-banks-lov/cash-banks-lov-update.component';
import { CashBanksLOVService } from 'app/entities/cash-banks-lov/cash-banks-lov.service';
import { CashBanksLOV } from 'app/shared/model/cash-banks-lov.model';

describe('Component Tests', () => {
  describe('CashBanksLOV Management Update Component', () => {
    let comp: CashBanksLOVUpdateComponent;
    let fixture: ComponentFixture<CashBanksLOVUpdateComponent>;
    let service: CashBanksLOVService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBanksLOVUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CashBanksLOVUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CashBanksLOVUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CashBanksLOVService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CashBanksLOV(123);
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
        const entity = new CashBanksLOV();
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
