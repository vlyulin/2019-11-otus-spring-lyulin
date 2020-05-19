import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IStandardReceipt, StandardReceipt } from 'app/shared/model/standard-receipt.model';
import { StandardReceiptService } from './standard-receipt.service';

@Component({
  selector: 'jhi-standard-receipt-update',
  templateUrl: './standard-receipt-update.component.html'
})
export class StandardReceiptUpdateComponent implements OnInit {
  isSaving = false;
  receiptDateDp: any;
  conversionDateDp: any;
  remittanceBankDepositDateDp: any;
  accountingDateDp: any;
  maturityDateDp: any;
  postmarkDateDp: any;
  creationDateDp: any;
  lastUpdateDateDp: any;

  editForm = this.fb.group({
    // id: [],
    standardReceiptId: [],
    receiptNumber: [],
    businessUnit: [],
    receiptMethod: [],
    receiptDate: [],
    documentNumber: [],
    amount: [],
    currency: [],
    conversionRateType: [],
    conversionDate: [],
    conversionRate: [],
    state: [],
    status: [],
    remittanceBankName: [],
    remittanceBankBranch: [],
    remittanceBankAccountNumber: [],
    remittanceBankDepositDate: [],
    remittanceBankAllowOverride: [],
    customerName: [],
    taxpayerIdentificationNumber: [],
    customerSite: [],
    customerAccountNumber: [],
    customerBank: [],
    customerBankBranch: [],
    customerBankAccountNumber: [],
    unappliedAmount: [],
    accountedAmount: [],
    accountingDate: [],
    maturityDate: [],
    postmarkDate: [],
    receiptAtRisk: [],
    receivablesSpecialist: [],
    comments: [],
    creditCardTokenNumber: [],
    creditCardAuthorizationRequestIdentifier: [],
    cardHolderFirstName: [],
    cardHolderLastName: [],
    creditCardIssuerCode: [],
    creditCardExpirationDate: [],
    voiceAuthorizationCode: [],
    createdBy: [],
    creationDate: [],
    lastUpdateDate: [],
    lastUpdatedBy: []
  });

  constructor(
    protected standardReceiptService: StandardReceiptService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ standardReceipt }) => {
      this.updateForm(standardReceipt);
    });
  }

  updateForm(standardReceipt: IStandardReceipt): void {
    this.editForm.patchValue({
      // id: standardReceipt.standardReceiptId,
      standardReceiptId: standardReceipt.standardReceiptId,
      receiptNumber: standardReceipt.receiptNumber,
      businessUnit: standardReceipt.businessUnit,
      receiptMethod: standardReceipt.receiptMethod,
      receiptDate: standardReceipt.receiptDate,
      documentNumber: standardReceipt.documentNumber,
      amount: standardReceipt.amount,
      currency: standardReceipt.currency,
      conversionRateType: standardReceipt.conversionRateType,
      conversionDate: standardReceipt.conversionDate,
      conversionRate: standardReceipt.conversionRate,
      state: standardReceipt.state,
      status: standardReceipt.status,
      remittanceBankName: standardReceipt.remittanceBankName,
      remittanceBankBranch: standardReceipt.remittanceBankBranch,
      remittanceBankAccountNumber: standardReceipt.remittanceBankAccountNumber,
      remittanceBankDepositDate: standardReceipt.remittanceBankDepositDate,
      remittanceBankAllowOverride: standardReceipt.remittanceBankAllowOverride,
      customerName: standardReceipt.customerName,
      taxpayerIdentificationNumber: standardReceipt.taxpayerIdentificationNumber,
      customerSite: standardReceipt.customerSite,
      customerAccountNumber: standardReceipt.customerAccountNumber,
      customerBank: standardReceipt.customerBank,
      customerBankBranch: standardReceipt.customerBankBranch,
      customerBankAccountNumber: standardReceipt.customerBankAccountNumber,
      unappliedAmount: standardReceipt.unappliedAmount,
      accountedAmount: standardReceipt.accountedAmount,
      accountingDate: standardReceipt.accountingDate,
      maturityDate: standardReceipt.maturityDate,
      postmarkDate: standardReceipt.postmarkDate,
      receiptAtRisk: standardReceipt.receiptAtRisk,
      receivablesSpecialist: standardReceipt.receivablesSpecialist,
      comments: standardReceipt.comments,
      creditCardTokenNumber: standardReceipt.creditCardTokenNumber,
      creditCardAuthorizationRequestIdentifier: standardReceipt.creditCardAuthorizationRequestIdentifier,
      cardHolderFirstName: standardReceipt.cardHolderFirstName,
      cardHolderLastName: standardReceipt.cardHolderLastName,
      creditCardIssuerCode: standardReceipt.creditCardIssuerCode,
      creditCardExpirationDate: standardReceipt.creditCardExpirationDate,
      voiceAuthorizationCode: standardReceipt.voiceAuthorizationCode,
      createdBy: standardReceipt.createdBy,
      creationDate: standardReceipt.creationDate,
      lastUpdateDate: standardReceipt.lastUpdateDate,
      lastUpdatedBy: standardReceipt.lastUpdatedBy
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const standardReceipt = this.createFromForm();
    if (standardReceipt.standardReceiptId !== undefined) {
      this.subscribeToSaveResponse(this.standardReceiptService.update(standardReceipt));
    } else {
      this.subscribeToSaveResponse(this.standardReceiptService.create(standardReceipt));
    }
  }

  private createFromForm(): IStandardReceipt {
    return {
      ...new StandardReceipt(),
      // id: this.editForm.get(['id'])!.value,
      standardReceiptId: this.editForm.get(['standardReceiptId'])!.value,
      receiptNumber: this.editForm.get(['receiptNumber'])!.value,
      businessUnit: this.editForm.get(['businessUnit'])!.value,
      receiptMethod: this.editForm.get(['receiptMethod'])!.value,
      receiptDate: this.editForm.get(['receiptDate'])!.value,
      documentNumber: this.editForm.get(['documentNumber'])!.value,
      amount: this.editForm.get(['amount'])!.value,
      currency: this.editForm.get(['currency'])!.value,
      conversionRateType: this.editForm.get(['conversionRateType'])!.value,
      conversionDate: this.editForm.get(['conversionDate'])!.value,
      conversionRate: this.editForm.get(['conversionRate'])!.value,
      state: this.editForm.get(['state'])!.value,
      status: this.editForm.get(['status'])!.value,
      remittanceBankName: this.editForm.get(['remittanceBankName'])!.value,
      remittanceBankBranch: this.editForm.get(['remittanceBankBranch'])!.value,
      remittanceBankAccountNumber: this.editForm.get(['remittanceBankAccountNumber'])!.value,
      remittanceBankDepositDate: this.editForm.get(['remittanceBankDepositDate'])!.value,
      remittanceBankAllowOverride: this.editForm.get(['remittanceBankAllowOverride'])!.value,
      customerName: this.editForm.get(['customerName'])!.value,
      taxpayerIdentificationNumber: this.editForm.get(['taxpayerIdentificationNumber'])!.value,
      customerSite: this.editForm.get(['customerSite'])!.value,
      customerAccountNumber: this.editForm.get(['customerAccountNumber'])!.value,
      customerBank: this.editForm.get(['customerBank'])!.value,
      customerBankBranch: this.editForm.get(['customerBankBranch'])!.value,
      customerBankAccountNumber: this.editForm.get(['customerBankAccountNumber'])!.value,
      unappliedAmount: this.editForm.get(['unappliedAmount'])!.value,
      accountedAmount: this.editForm.get(['accountedAmount'])!.value,
      accountingDate: this.editForm.get(['accountingDate'])!.value,
      maturityDate: this.editForm.get(['maturityDate'])!.value,
      postmarkDate: this.editForm.get(['postmarkDate'])!.value,
      receiptAtRisk: this.editForm.get(['receiptAtRisk'])!.value,
      receivablesSpecialist: this.editForm.get(['receivablesSpecialist'])!.value,
      comments: this.editForm.get(['comments'])!.value,
      creditCardTokenNumber: this.editForm.get(['creditCardTokenNumber'])!.value,
      creditCardAuthorizationRequestIdentifier: this.editForm.get(['creditCardAuthorizationRequestIdentifier'])!.value,
      cardHolderFirstName: this.editForm.get(['cardHolderFirstName'])!.value,
      cardHolderLastName: this.editForm.get(['cardHolderLastName'])!.value,
      creditCardIssuerCode: this.editForm.get(['creditCardIssuerCode'])!.value,
      creditCardExpirationDate: this.editForm.get(['creditCardExpirationDate'])!.value,
      voiceAuthorizationCode: this.editForm.get(['voiceAuthorizationCode'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      creationDate: this.editForm.get(['creationDate'])!.value,
      lastUpdateDate: this.editForm.get(['lastUpdateDate'])!.value,
      lastUpdatedBy: this.editForm.get(['lastUpdatedBy'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStandardReceipt>>): void {
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
