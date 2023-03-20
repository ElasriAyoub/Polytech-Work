import { TestBed } from '@angular/core/testing';

import { CreateDogProfileService } from './create-dog-profile.service';

describe('CreateDogProfileService', () => {
  let service: CreateDogProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateDogProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
