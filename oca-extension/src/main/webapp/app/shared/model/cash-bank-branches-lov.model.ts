export interface ICashBankBranchesLOV {
  // id?: number;
  branchPartyId?: number;
  bankBranchName?: string;
  branchNumber?: string;
  bankName?: string;
}

export class CashBankBranchesLOV implements ICashBankBranchesLOV {
  constructor(
    // public id?: number,
    public branchPartyId?: number,
    public bankBranchName?: string,
    public branchNumber?: string,
    public bankName?: string
  ) {}
}
