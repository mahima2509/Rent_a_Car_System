import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllReviewComponent } from './displayallreview.component';

describe('DisplayallreviewComponent', () => {
  let component: DisplayAllReviewComponent;
  let fixture: ComponentFixture<DisplayAllReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllReviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayAllReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
