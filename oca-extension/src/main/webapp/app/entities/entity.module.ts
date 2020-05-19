import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'standard-receipt',
        loadChildren: () => import('./standard-receipt/standard-receipt.module').then(m => m.OracleCloudAppExtensionStandardReceiptModule)
      },
      {
        path: 'cash-banks-lov',
        loadChildren: () => import('./cash-banks-lov/cash-banks-lov.module').then(m => m.OracleCloudAppExtensionCashBanksLOVModule)
      },
      {
        path: 'cash-bank-branches-lov',
        loadChildren: () =>
          import('./cash-bank-branches-lov/cash-bank-branches-lov.module').then(m => m.OracleCloudAppExtensionCashBankBranchesLOVModule)
      },
      {
        path: 'cash-bank-accounts-lov',
        loadChildren: () =>
          import('./cash-bank-accounts-lov/cash-bank-accounts-lov.module').then(m => m.OracleCloudAppExtensionCashBankAccountsLOVModule)
      },
      {
        path: 'customer-account-sites-lov',
        loadChildren: () =>
          import('./customer-account-sites-lov/customer-account-sites-lov.module').then(
            m => m.OracleCloudAppExtensionCustomerAccountSitesLOVModule
          )
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class OracleCloudAppExtensionEntityModule {}
