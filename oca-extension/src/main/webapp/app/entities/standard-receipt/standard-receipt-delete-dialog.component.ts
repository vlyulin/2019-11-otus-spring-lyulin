import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IStandardReceipt } from 'app/shared/model/standard-receipt.model';
import { StandardReceiptService } from './standard-receipt.service';

@Component({
  templateUrl: './standard-receipt-delete-dialog.component.html'
})
export class StandardReceiptDeleteDialogComponent {
  standardReceipt?: IStandardReceipt;

  constructor(
    protected standardReceiptService: StandardReceiptService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.standardReceiptService.delete(id).subscribe(() => {
      this.eventManager.broadcast('standardReceiptListModification');
      this.activeModal.close();
    });
  }
}
