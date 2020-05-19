import { Moment } from 'moment';

export interface IStandardReceipt {
  // id?: number;
  standardReceiptId?: number;
  receiptNumber?: string;
  businessUnit?: string;
  receiptMethod?: string;
  receiptDate?: Moment;
  documentNumber?: number;
  amount?: number;
  currency?: string;
  conversionRateType?: string;
  conversionDate?: Moment;
  conversionRate?: number;
  state?: string;
  status?: string;
  remittanceBankName?: string;
  remittanceBankBranch?: string;
  remittanceBankAccountNumber?: string;
  remittanceBankDepositDate?: Moment;
  remittanceBankAllowOverride?: string;
  customerName?: string;
  taxpayerIdentificationNumber?: string;
  customerSite?: string;
  customerAccountNumber?: string;
  customerBank?: string;
  customerBankBranch?: string;
  customerBankAccountNumber?: string;
  unappliedAmount?: number;
  accountedAmount?: number;
  accountingDate?: Moment;
  maturityDate?: Moment;
  postmarkDate?: Moment;
  receiptAtRisk?: string;
  receivablesSpecialist?: string;
  comments?: string;
  creditCardTokenNumber?: string;
  creditCardAuthorizationRequestIdentifier?: number;
  cardHolderFirstName?: string;
  cardHolderLastName?: string;
  creditCardIssuerCode?: string;
  creditCardExpirationDate?: string;
  voiceAuthorizationCode?: string;
  createdBy?: string;
  creationDate?: Moment;
  lastUpdateDate?: Moment;
  lastUpdatedBy?: string;
}

export class StandardReceipt implements IStandardReceipt {
  constructor(
    // public id?: number,
    public standardReceiptId?: number,
    public receiptNumber?: string,
    public businessUnit?: string,
    public receiptMethod?: string,
    public receiptDate?: Moment,
    public documentNumber?: number,
    public amount?: number,
    public currency?: string,
    public conversionRateType?: string,
    public conversionDate?: Moment,
    public conversionRate?: number,
    public state?: string,
    public status?: string,
    public remittanceBankName?: string,
    public remittanceBankBranch?: string,
    public remittanceBankAccountNumber?: string,
    public remittanceBankDepositDate?: Moment,
    public remittanceBankAllowOverride?: string,
    public customerName?: string,
    public taxpayerIdentificationNumber?: string,
    public customerSite?: string,
    public customerAccountNumber?: string,
    public customerBank?: string,
    public customerBankBranch?: string,
    public customerBankAccountNumber?: string,
    public unappliedAmount?: number,
    public accountedAmount?: number,
    public accountingDate?: Moment,
    public maturityDate?: Moment,
    public postmarkDate?: Moment,
    public receiptAtRisk?: string,
    public receivablesSpecialist?: string,
    public comments?: string,
    public creditCardTokenNumber?: string,
    public creditCardAuthorizationRequestIdentifier?: number,
    public cardHolderFirstName?: string,
    public cardHolderLastName?: string,
    public creditCardIssuerCode?: string,
    public creditCardExpirationDate?: string,
    public voiceAuthorizationCode?: string,
    public createdBy?: string,
    public creationDate?: Moment,
    public lastUpdateDate?: Moment,
    public lastUpdatedBy?: string
  ) {}
}
