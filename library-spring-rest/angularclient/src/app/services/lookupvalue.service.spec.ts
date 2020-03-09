import { TestBed } from '@angular/core/testing';

import { LookupvalueService } from './lookupvalue.service';

describe('LookupvalueService', () => {
  let service: LookupvalueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LookupvalueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
