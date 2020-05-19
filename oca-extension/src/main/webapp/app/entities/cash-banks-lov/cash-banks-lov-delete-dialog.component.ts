import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICashBanksLOV } from 'app/shared/model/cash-banks-lov.model';
import { CashBanksLOVService } from './cash-banks-lov.service';

@Component({
  templateUrl: './cash-banks-lov-delete-dialog.component.html'
})
export class CashBanksLOVDeleteDialogComponent {
  cashBanksLOV?: ICashBanksLOV;

  constructor(
    protected cashBanksLOVService: CashBanksLOVService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.cashBanksLOVService.delete(id).subscribe(() => {
      this.eventManager.broadcast('cashBanksLOVListModification');
      this.activeModal.close();
    });
  }
}
