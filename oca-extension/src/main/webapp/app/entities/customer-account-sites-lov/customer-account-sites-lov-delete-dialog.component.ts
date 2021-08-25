import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';
import { CustomerAccountSitesLOVService } from './customer-account-sites-lov.service';

@Component({
  templateUrl: './customer-account-sites-lov-delete-dialog.component.html'
})
export class CustomerAccountSitesLOVDeleteDialogComponent {
  customerAccountSitesLOV?: ICustomerAccountSitesLOV;

  constructor(
    protected customerAccountSitesLOVService: CustomerAccountSitesLOVService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.customerAccountSitesLOVService.delete(id).subscribe(() => {
      this.eventManager.broadcast('customerAccountSitesLOVListModification');
      this.activeModal.close();
    });
  }
}
