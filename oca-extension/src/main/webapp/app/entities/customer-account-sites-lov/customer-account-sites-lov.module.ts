import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OracleCloudAppExtensionSharedModule } from 'app/shared/shared.module';
import { CustomerAccountSitesLOVComponent } from './customer-account-sites-lov.component';
import { CustomerAccountSitesLOVDetailComponent } from './customer-account-sites-lov-detail.component';
import { CustomerAccountSitesLOVUpdateComponent } from './customer-account-sites-lov-update.component';
import { CustomerAccountSitesLOVDeleteDialogComponent } from './customer-account-sites-lov-delete-dialog.component';
import { customerAccountSitesLOVRoute } from './customer-account-sites-lov.route';

@NgModule({
  imports: [OracleCloudAppExtensionSharedModule, RouterModule.forChild(customerAccountSitesLOVRoute)],
  declarations: [
    CustomerAccountSitesLOVComponent,
    CustomerAccountSitesLOVDetailComponent,
    CustomerAccountSitesLOVUpdateComponent,
    CustomerAccountSitesLOVDeleteDialogComponent
  ],
  entryComponents: [CustomerAccountSitesLOVDeleteDialogComponent]
})
export class OracleCloudAppExtensionCustomerAccountSitesLOVModule {}
