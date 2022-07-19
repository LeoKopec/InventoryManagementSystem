import { TestBed } from '@angular/core/testing';

import { FruitApiService } from './fruit-api.service';

describe('FruitApiService', () => {
  let service: FruitApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FruitApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
