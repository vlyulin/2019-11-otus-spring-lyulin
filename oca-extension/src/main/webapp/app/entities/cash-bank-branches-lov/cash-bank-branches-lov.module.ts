import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OracleCloudAppExtensionSharedModule } from 'app/shared/shared.module';
import { CashBankBranchesLOVComponent } from './cash-bank-branches-lov.component';
import { CashBankBranchesLOVDetailComponent } from './cash-bank-branches-lov-detail.component';
import { CashBankBranchesLOVUpdateComponent } from './cash-bank-branches-lov-update.component';
import { CashBankBranchesLOVDeleteDialogComponent } from './cash-bank-branches-lov-delete-dialog.component';
import { cashBankBranchesLOVRoute } from './cash-bank-branches-lov.route';

@NgModule({
  imports: [OracleCloudAppExtensionSharedModule, RouterModule.forChild(cashBankBranchesLOVRoute)],
  declarations: [
    CashBankBranchesLOVComponent,
    CashBankBranchesLOVDetailComponent,
    CashBankBranchesLOVUpdateComponent,
    CashBankBranchesLOVDeleteDialogComponent
  ],
  entryComponents: [CashBankBranchesLOVDeleteDialogComponent]
})
export class OracleCloudAppExtensionCashBankBranchesLOVModule {}
