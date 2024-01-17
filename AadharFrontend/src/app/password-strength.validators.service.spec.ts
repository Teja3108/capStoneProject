import { TestBed } from '@angular/core/testing';

import { PasswordStrengthValidatorsService } from './password-strength.validators.service';

describe('PasswordStrengthValidatorsService', () => {
  let service: PasswordStrengthValidatorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PasswordStrengthValidatorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
