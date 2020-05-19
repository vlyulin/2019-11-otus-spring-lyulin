import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICashBankAccountsLOV, CashBankAccountsLOV } from 'app/shared/model/cash-bank-accounts-lov.model';
import { CashBankAccountsLOVService } from './cash-bank-accounts-lov.service';

@Component({
  selector: 'jhi-cash-bank-accounts-lov-update',
  templateUrl: './cash-bank-accounts-lov-update.component.html'
})
export class CashBankAccountsLOVUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    // id: [],
    bankAccountId: [],
    bankAccountName: [],
    maskedAccountNumber: []
  });

  constructor(
    protected cashBankAccountsLOVService: CashBankAccountsLOVService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cashBankAccountsLOV }) => {
      this.updateForm(cashBankAccountsLOV);
    });
  }

  updateForm(cashBankAccountsLOV: ICashBankAccountsLOV): void {
    this.editForm.patchValue({
      // id: cashBankAccountsLOV.id,
      bankAccountId: cashBankAccountsLOV.bankAccountId,
      bankAccountName: cashBankAccountsLOV.bankAccountName,
      maskedAccountNumber: cashBankAccountsLOV.maskedAccountNumber
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const cashBankAccountsLOV = this.createFromForm();
    if (cashBankAccountsLOV.bankAccountId !== undefined) {
      this.subscribeToSaveResponse(this.cashBankAccountsLOVService.update(cashBankAccountsLOV));
    } else {
      this.subscribeToSaveResponse(this.cashBankAccountsLOVService.create(cashBankAccountsLOV));
    }
  }

  private createFromForm(): ICashBankAccountsLOV {
    return {
      ...new CashBankAccountsLOV(),
      // id: this.editForm.get(['id'])!.value,
      bankAccountId: this.editForm.get(['bankAccountId'])!.value,
      bankAccountName: this.editForm.get(['bankAccountName'])!.value,
      maskedAccountNumber: this.editForm.get(['maskedAccountNumber'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICashBankAccountsLOV>>): void {
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
