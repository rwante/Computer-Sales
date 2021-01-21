import { TestBed } from '@angular/core/testing';

import { HddService } from './hdd.service';

describe('HddService', () => {
  let service: HddService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HddService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
