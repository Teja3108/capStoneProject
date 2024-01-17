import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IssueAdharComponentComponent } from './issue.adhar.component.component';

describe('IssueAdharComponentComponent', () => {
  let component: IssueAdharComponentComponent;
  let fixture: ComponentFixture<IssueAdharComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IssueAdharComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IssueAdharComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
