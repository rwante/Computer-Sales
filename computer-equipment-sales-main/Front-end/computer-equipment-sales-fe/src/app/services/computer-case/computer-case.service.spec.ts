import { TestBed } from '@angular/core/testing';

import { ComputerCaseService } from './computer-case.service';

describe('ComputerCaseService', () => {
  let service: ComputerCaseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComputerCaseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
