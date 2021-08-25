import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CustomerAccountSitesLOVUpdateComponent } from 'app/entities/customer-account-sites-lov/customer-account-sites-lov-update.component';
import { CustomerAccountSitesLOVService } from 'app/entities/customer-account-sites-lov/customer-account-sites-lov.service';
import { CustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';

describe('Component Tests', () => {
  describe('CustomerAccountSitesLOV Management Update Component', () => {
    let comp: CustomerAccountSitesLOVUpdateComponent;
    let fixture: ComponentFixture<CustomerAccountSitesLOVUpdateComponent>;
    let service: CustomerAccountSitesLOVService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CustomerAccountSitesLOVUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CustomerAccountSitesLOVUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CustomerAccountSitesLOVUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CustomerAccountSitesLOVService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new CustomerAccountSitesLOV(123);
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
        const entity = new CustomerAccountSitesLOV();
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
