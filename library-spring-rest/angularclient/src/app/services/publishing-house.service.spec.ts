import { TestBed } from '@angular/core/testing';

import { PublishingHouseService } from './publishing-house.service';

describe('PublishingHouseService', () => {
  let service: PublishingHouseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PublishingHouseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
