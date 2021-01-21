import { TestBed } from '@angular/core/testing';

import { DisplayCardService } from './display-card.service';

describe('DisplayCardService', () => {
  let service: DisplayCardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DisplayCardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
