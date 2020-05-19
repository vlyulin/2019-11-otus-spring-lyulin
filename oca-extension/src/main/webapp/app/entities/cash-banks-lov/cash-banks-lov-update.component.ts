import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICashBanksLOV, CashBanksLOV } from 'app/shared/model/cash-banks-lov.model';
import { CashBanksLOVService } from './cash-banks-lov.service';

@Component({
  selector: 'jhi-cash-banks-lov-update',
  templateUrl: './cash-banks-lov-update.component.html'
})
export class CashBanksLOVUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    // id: [], // VL
    bankName: [],
    bankNumber: [],
    bankPartyId: []
  });

  constructor(protected cashBanksLOVService: CashBanksLOVService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cashBanksLOV }) => {
      this.updateForm(cashBanksLOV);
    });
  }

  updateForm(cashBanksLOV: ICashBanksLOV): void {
    this.editForm.patchValue({
      // id: cashBanksLOV.id, // VL
      bankName: cashBanksLOV.bankName,
      bankNumber: cashBanksLOV.bankNumber,
      bankPartyId: cashBanksLOV.bankPartyId
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const cashBanksLOV = this.createFromForm();
    if (cashBanksLOV.bankPartyId !== undefined) { // cashBanksLOV.id
      this.subscribeToSaveResponse(this.cashBanksLOVService.update(cashBanksLOV));
    } else {
      this.subscribeToSaveResponse(this.cashBanksLOVService.create(cashBanksLOV));
    }
  }

  private createFromForm(): ICashBanksLOV {
    return {
      ...new CashBanksLOV(),
      // id: this.editForm.get(['id'])!.value,
      bankName: this.editForm.get(['bankName'])!.value,
      bankNumber: this.editForm.get(['bankNumber'])!.value,
      bankPartyId: this.editForm.get(['bankPartyId'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICashBanksLOV>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
