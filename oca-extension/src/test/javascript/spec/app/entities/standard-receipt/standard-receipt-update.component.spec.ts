import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { StandardReceiptUpdateComponent } from 'app/entities/standard-receipt/standard-receipt-update.component';
import { StandardReceiptService } from 'app/entities/standard-receipt/standard-receipt.service';
import { StandardReceipt } from 'app/shared/model/standard-receipt.model';

describe('Component Tests', () => {
  describe('StandardReceipt Management Update Component', () => {
    let comp: StandardReceiptUpdateComponent;
    let fixture: ComponentFixture<StandardReceiptUpdateComponent>;
    let service: StandardReceiptService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [StandardReceiptUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(StandardReceiptUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(StandardReceiptUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(StandardReceiptService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new StandardReceipt(123);
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
        const entity = new StandardReceipt();
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
