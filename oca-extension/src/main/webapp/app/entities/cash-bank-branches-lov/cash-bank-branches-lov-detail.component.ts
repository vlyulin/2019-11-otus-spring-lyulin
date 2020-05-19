import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';

@Component({
  selector: 'jhi-cash-bank-branches-lov-detail',
  templateUrl: './cash-bank-branches-lov-detail.component.html'
})
export class CashBankBranchesLOVDetailComponent implements OnInit {
  cashBankBranchesLOV: ICashBankBranchesLOV | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cashBankBranchesLOV }) => (this.cashBankBranchesLOV = cashBankBranchesLOV));
  }

  previousState(): void {
    window.history.back();
  }
}
