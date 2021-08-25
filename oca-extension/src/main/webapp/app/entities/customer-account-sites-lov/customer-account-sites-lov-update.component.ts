import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICustomerAccountSitesLOV, CustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';
import { CustomerAccountSitesLOVService } from './customer-account-sites-lov.service';

@Component({
  selector: 'jhi-customer-account-sites-lov-update',
  templateUrl: './customer-account-sites-lov-update.component.html'
})
export class CustomerAccountSitesLOVUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    // id: [],
    customerName: [],
    accountNumber: [],
    accountDescription: [],
    taxpayerIdentificationNumber: [],
    taxRegistrationNumber: [],
    customerAccountId: [],
    partyNumber: [],
    siteName: [],
    primarySite: [],
    siteUseId: [],
    setName: []
  });

  constructor(
    protected customerAccountSitesLOVService: CustomerAccountSitesLOVService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ customerAccountSitesLOV }) => {
      this.updateForm(customerAccountSitesLOV);
    });
  }

  updateForm(customerAccountSitesLOV: ICustomerAccountSitesLOV): void {
    this.editForm.patchValue({
      // id: customerAccountSitesLOV.id,
      customerName: customerAccountSitesLOV.customerName,
      accountNumber: customerAccountSitesLOV.accountNumber,
      accountDescription: customerAccountSitesLOV.accountDescription,
      taxpayerIdentificationNumber: customerAccountSitesLOV.taxpayerIdentificationNumber,
      taxRegistrationNumber: customerAccountSitesLOV.taxRegistrationNumber,
      customerAccountId: customerAccountSitesLOV.customerAccountId,
      partyNumber: customerAccountSitesLOV.partyNumber,
      siteName: customerAccountSitesLOV.siteName,
      primarySite: customerAccountSitesLOV.primarySite,
      siteUseId: customerAccountSitesLOV.siteUseId,
      setName: customerAccountSitesLOV.setName
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const customerAccountSitesLOV = this.createFromForm();
    if (customerAccountSitesLOV.siteUseId !== undefined) {
      this.subscribeToSaveResponse(this.customerAccountSitesLOVService.update(customerAccountSitesLOV));
    } else {
      this.subscribeToSaveResponse(this.customerAccountSitesLOVService.create(customerAccountSitesLOV));
    }
  }

  private createFromForm(): ICustomerAccountSitesLOV {
    return {
      ...new CustomerAccountSitesLOV(),
      // id: this.editForm.get(['id'])!.value,
      customerName: this.editForm.get(['customerName'])!.value,
      accountNumber: this.editForm.get(['accountNumber'])!.value,
      accountDescription: this.editForm.get(['accountDescription'])!.value,
      taxpayerIdentificationNumber: this.editForm.get(['taxpayerIdentificationNumber'])!.value,
      taxRegistrationNumber: this.editForm.get(['taxRegistrationNumber'])!.value,
      customerAccountId: this.editForm.get(['customerAccountId'])!.value,
      partyNumber: this.editForm.get(['partyNumber'])!.value,
      siteName: this.editForm.get(['siteName'])!.value,
      primarySite: this.editForm.get(['primarySite'])!.value,
      siteUseId: this.editForm.get(['siteUseId'])!.value,
      setName: this.editForm.get(['setName'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICustomerAccountSitesLOV>>): void {
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
