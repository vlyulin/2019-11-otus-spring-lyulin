export interface ICashBankAccountsLOV {
  // id?: number;
  bankAccountId?: number;
  bankAccountName?: string;
  maskedAccountNumber?: string;
}

export class CashBankAccountsLOV implements ICashBankAccountsLOV {
  constructor(public bankAccountId?: number, public bankAccountName?: string, public maskedAccountNumber?: string) {}
}
//  public id?: number, 
