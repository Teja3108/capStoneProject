import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserhomeComponentComponent } from './userhome.component.component';

describe('UserhomeComponentComponent', () => {
  let component: UserhomeComponentComponent;
  let fixture: ComponentFixture<UserhomeComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserhomeComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserhomeComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
