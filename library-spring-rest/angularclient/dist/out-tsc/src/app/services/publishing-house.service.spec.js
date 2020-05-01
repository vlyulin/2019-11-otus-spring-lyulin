import { TestBed } from '@angular/core/testing';
import { PublishingHouseService } from './publishing-house.service';
describe('PublishingHouseService', () => {
    let service;
    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(PublishingHouseService);
    });
    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
//# sourceMappingURL=publishing-house.service.spec.js.map