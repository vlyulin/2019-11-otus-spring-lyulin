import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { StandardReceiptDeleteDialogComponent } from 'app/entities/standard-receipt/standard-receipt-delete-dialog.component';
import { StandardReceiptService } from 'app/entities/standard-receipt/standard-receipt.service';

describe('Component Tests', () => {
  describe('StandardReceipt Management Delete Component', () => {
    let comp: StandardReceiptDeleteDialogComponent;
    let fixture: ComponentFixture<StandardReceiptDeleteDialogComponent>;
    let service: StandardReceiptService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [StandardReceiptDeleteDialogComponent]
      })
        .overrideTemplate(StandardReceiptDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(StandardReceiptDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(StandardReceiptService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
