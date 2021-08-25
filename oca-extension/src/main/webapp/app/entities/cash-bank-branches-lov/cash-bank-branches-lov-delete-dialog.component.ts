import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';
import { CashBankBranchesLOVService } from './cash-bank-branches-lov.service';

@Component({
  templateUrl: './cash-bank-branches-lov-delete-dialog.component.html'
})
export class CashBankBranchesLOVDeleteDialogComponent {
  cashBankBranchesLOV?: ICashBankBranchesLOV;

  constructor(
    protected cashBankBranchesLOVService: CashBankBranchesLOVService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.cashBankBranchesLOVService.delete(id).subscribe(() => {
      this.eventManager.broadcast('cashBankBranchesLOVListModification');
      this.activeModal.close();
    });
  }
}
