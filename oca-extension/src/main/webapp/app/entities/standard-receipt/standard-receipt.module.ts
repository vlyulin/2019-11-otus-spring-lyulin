import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OracleCloudAppExtensionSharedModule } from 'app/shared/shared.module';
import { StandardReceiptComponent } from './standard-receipt.component';
import { StandardReceiptDetailComponent } from './standard-receipt-detail.component';
import { StandardReceiptUpdateComponent } from './standard-receipt-update.component';
import { StandardReceiptDeleteDialogComponent } from './standard-receipt-delete-dialog.component';
import { standardReceiptRoute } from './standard-receipt.route';

@NgModule({
  imports: [OracleCloudAppExtensionSharedModule, RouterModule.forChild(standardReceiptRoute)],
  declarations: [
    StandardReceiptComponent,
    StandardReceiptDetailComponent,
    StandardReceiptUpdateComponent,
    StandardReceiptDeleteDialogComponent
  ],
  entryComponents: [StandardReceiptDeleteDialogComponent]
})
export class OracleCloudAppExtensionStandardReceiptModule {}
