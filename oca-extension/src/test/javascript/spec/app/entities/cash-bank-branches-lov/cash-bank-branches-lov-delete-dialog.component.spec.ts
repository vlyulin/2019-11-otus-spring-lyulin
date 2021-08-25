import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { CashBankBranchesLOVDeleteDialogComponent } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov-delete-dialog.component';
import { CashBankBranchesLOVService } from 'app/entities/cash-bank-branches-lov/cash-bank-branches-lov.service';

describe('Component Tests', () => {
  describe('CashBankBranchesLOV Management Delete Component', () => {
    let comp: CashBankBranchesLOVDeleteDialogComponent;
    let fixture: ComponentFixture<CashBankBranchesLOVDeleteDialogComponent>;
    let service: CashBankBranchesLOVService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CashBankBranchesLOVDeleteDialogComponent]
      })
        .overrideTemplate(CashBankBranchesLOVDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CashBankBranchesLOVDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CashBankBranchesLOVService);
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
