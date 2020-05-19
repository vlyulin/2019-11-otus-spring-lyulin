import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICashBanksLOV } from 'app/shared/model/cash-banks-lov.model';

@Component({
  selector: 'jhi-cash-banks-lov-detail',
  templateUrl: './cash-banks-lov-detail.component.html'
})
export class CashBanksLOVDetailComponent implements OnInit {
  cashBanksLOV: ICashBanksLOV | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    console.warn('XXX LOV detail');
    this.activatedRoute.data.subscribe(({ cashBanksLOV }) => (this.cashBanksLOV = cashBanksLOV));
  }

  previousState(): void {
    window.history.back();
  }
}
