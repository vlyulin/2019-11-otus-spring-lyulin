export interface ICustomerAccountSitesLOV {
  // id?: number;
  customerName?: string;
  accountNumber?: string;
  accountDescription?: string;
  taxpayerIdentificationNumber?: string;
  taxRegistrationNumber?: string;
  customerAccountId?: number;
  partyNumber?: string;
  siteName?: string;
  primarySite?: string;
  siteUseId?: number;
  setName?: string;
}

export class CustomerAccountSitesLOV implements ICustomerAccountSitesLOV {
  constructor(
    // public id?: number,
    public customerName?: string,
    public accountNumber?: string,
    public accountDescription?: string,
    public taxpayerIdentificationNumber?: string,
    public taxRegistrationNumber?: string,
    public customerAccountId?: number,
    public partyNumber?: string,
    public siteName?: string,
    public primarySite?: string,
    public siteUseId?: number,
    public setName?: string
  ) {}
}
