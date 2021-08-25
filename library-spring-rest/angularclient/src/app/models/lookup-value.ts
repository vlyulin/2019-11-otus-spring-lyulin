import { LookupValueId } from './lookup-value-id';

export class LookupValue {
    key: LookupValueId;
    enabledFlag: string;
    startDateActive: Date;
    endDateActive: Date;
    meaning: string;
    description: string;
}
