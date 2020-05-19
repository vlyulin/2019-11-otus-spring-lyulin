export interface ICashBanksLOV {
  // id?: number; VL
  bankName?: string;
  bankNumber?: string;
  bankPartyId?: number;
}

export class CashBanksLOV implements ICashBanksLOV {
  constructor(public bankPartyId?: number, public bankName?: string, public bankNumber?: string) {}
}
// public id?: number, 
