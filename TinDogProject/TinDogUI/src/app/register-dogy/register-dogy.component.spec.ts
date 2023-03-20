import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterDogyComponent } from './register-dogy.component';

describe('RegisterDogyComponent', () => {
  let component: RegisterDogyComponent;
  let fixture: ComponentFixture<RegisterDogyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterDogyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterDogyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
