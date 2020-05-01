import { TestBed } from '@angular/core/testing';
import { LookupValueService } from './lookupvalue.service';
describe('LookupvalueService', () => {
    let service;
    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(LookupValueService);
    });
    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
//# sourceMappingURL=lookupvalue.service.spec.js.map