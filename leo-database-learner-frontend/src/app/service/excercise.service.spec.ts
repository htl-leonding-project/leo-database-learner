import { TestBed } from '@angular/core/testing';

import { ExcerciseService } from './excercise.service';

describe('ExcerciseService', () => {
  let service: ExcerciseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExcerciseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
