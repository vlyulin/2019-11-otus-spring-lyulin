import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OracleCloudAppExtensionSharedModule } from 'app/shared/shared.module';
import { CashBanksLOVComponent } from './cash-banks-lov.component';
import { CashBanksLOVDetailComponent } from './cash-banks-lov-detail.component';
import { CashBanksLOVUpdateComponent } from './cash-banks-lov-update.component';
import { CashBanksLOVDeleteDialogComponent } from './cash-banks-lov-delete-dialog.component';
import { cashBanksLOVRoute } from './cash-banks-lov.route';

@NgModule({
  imports: [OracleCloudAppExtensionSharedModule, RouterModule.forChild(cashBanksLOVRoute)],
  declarations: [CashBanksLOVComponent, CashBanksLOVDetailComponent, CashBanksLOVUpdateComponent, CashBanksLOVDeleteDialogComponent],
  entryComponents: [CashBanksLOVDeleteDialogComponent]
})
export class OracleCloudAppExtensionCashBanksLOVModule {}
