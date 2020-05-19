import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IStandardReceipt } from 'app/shared/model/standard-receipt.model';

@Component({
  selector: 'jhi-standard-receipt-detail',
  templateUrl: './standard-receipt-detail.component.html'
})
export class StandardReceiptDetailComponent implements OnInit {
  standardReceipt: IStandardReceipt | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ standardReceipt }) => (this.standardReceipt = standardReceipt));
  }

  previousState(): void {
    window.history.back();
  }
}
