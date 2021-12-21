import { TestBed } from '@angular/core/testing';

import { LinkmenuService } from './linkmenu.service';

describe('LinkmenuService', () => {
  let service: LinkmenuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LinkmenuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
