import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminhomeComponentComponent } from './adminhome.component.component';

describe('AdminhomeComponentComponent', () => {
  let component: AdminhomeComponentComponent;
  let fixture: ComponentFixture<AdminhomeComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminhomeComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminhomeComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
