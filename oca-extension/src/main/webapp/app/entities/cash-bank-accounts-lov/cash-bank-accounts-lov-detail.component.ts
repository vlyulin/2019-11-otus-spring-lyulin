import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';

@Component({
  selector: 'jhi-cash-bank-accounts-lov-detail',
  templateUrl: './cash-bank-accounts-lov-detail.component.html'
})
export class CashBankAccountsLOVDetailComponent implements OnInit {
  cashBankAccountsLOV: ICashBankAccountsLOV | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cashBankAccountsLOV }) => (this.cashBankAccountsLOV = cashBankAccountsLOV));
  }

  previousState(): void {
    window.history.back();
  }
}
