import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';
import { CashBankAccountsLOVService } from './cash-bank-accounts-lov.service';

@Component({
  templateUrl: './cash-bank-accounts-lov-delete-dialog.component.html'
})
export class CashBankAccountsLOVDeleteDialogComponent {
  cashBankAccountsLOV?: ICashBankAccountsLOV;

  constructor(
    protected cashBankAccountsLOVService: CashBankAccountsLOVService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.cashBankAccountsLOVService.delete(id).subscribe(() => {
      this.eventManager.broadcast('cashBankAccountsLOVListModification');
      this.activeModal.close();
    });
  }
}
