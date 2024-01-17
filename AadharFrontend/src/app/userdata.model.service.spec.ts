import { TestBed } from '@angular/core/testing';

import { UserdataModelService } from './userdata.model.service';

describe('UserdataModelService', () => {
  let service: UserdataModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserdataModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
