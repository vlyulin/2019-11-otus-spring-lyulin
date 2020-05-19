import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OracleCloudAppExtensionSharedModule } from 'app/shared/shared.module';
import { CashBankAccountsLOVComponent } from './cash-bank-accounts-lov.component';
import { CashBankAccountsLOVDetailComponent } from './cash-bank-accounts-lov-detail.component';
import { CashBankAccountsLOVUpdateComponent } from './cash-bank-accounts-lov-update.component';
import { CashBankAccountsLOVDeleteDialogComponent } from './cash-bank-accounts-lov-delete-dialog.component';
import { cashBankAccountsLOVRoute } from './cash-bank-accounts-lov.route';

@NgModule({
  imports: [OracleCloudAppExtensionSharedModule, RouterModule.forChild(cashBankAccountsLOVRoute)],
  declarations: [
    CashBankAccountsLOVComponent,
    CashBankAccountsLOVDetailComponent,
    CashBankAccountsLOVUpdateComponent,
    CashBankAccountsLOVDeleteDialogComponent
  ],
  entryComponents: [CashBankAccountsLOVDeleteDialogComponent]
})
export class OracleCloudAppExtensionCashBankAccountsLOVModule {}
