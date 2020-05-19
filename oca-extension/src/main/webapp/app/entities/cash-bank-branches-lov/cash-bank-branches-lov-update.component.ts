import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICashBankBranchesLOV, CashBankBranchesLOV } from 'app/shared/model/cash-bank-branches-lov.model';
import { CashBankBranchesLOVService } from './cash-bank-branches-lov.service';

@Component({
  selector: 'jhi-cash-bank-branches-lov-update',
  templateUrl: './cash-bank-branches-lov-update.component.html'
})
export class CashBankBranchesLOVUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    // id: [],
    branchPartyId: [],
    bankBranchName: [],
    branchNumber: [],
    bankName: []
  });

  constructor(
    protected cashBankBranchesLOVService: CashBankBranchesLOVService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cashBankBranchesLOV }) => {
      this.updateForm(cashBankBranchesLOV);
    });
  }

  updateForm(cashBankBranchesLOV: ICashBankBranchesLOV): void {
    this.editForm.patchValue({
      // id: cashBankBranchesLOV.id,
      branchPartyId: cashBankBranchesLOV.branchPartyId,
      bankBranchName: cashBankBranchesLOV.bankBranchName,
      branchNumber: cashBankBranchesLOV.branchNumber,
      bankName: cashBankBranchesLOV.bankName
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const cashBankBranchesLOV = this.createFromForm();
    if (cashBankBranchesLOV.branchPartyId !== undefined) {
      this.subscribeToSaveResponse(this.cashBankBranchesLOVService.update(cashBankBranchesLOV));
    } else {
      this.subscribeToSaveResponse(this.cashBankBranchesLOVService.create(cashBankBranchesLOV));
    }
  }

  private createFromForm(): ICashBankBranchesLOV {
    return {
      ...new CashBankBranchesLOV(),
      // id: this.editForm.get(['id'])!.value,
      branchPartyId: this.editForm.get(['branchPartyId'])!.value,
      bankBranchName: this.editForm.get(['bankBranchName'])!.value,
      branchNumber: this.editForm.get(['branchNumber'])!.value,
      bankName: this.editForm.get(['bankName'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICashBankBranchesLOV>>): void {
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
