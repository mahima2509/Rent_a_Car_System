import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateReviewComponent } from './updatereview.component';

describe('UpdatereviewComponent', () => {
  let component: UpdateReviewComponent;
  let fixture: ComponentFixture<UpdateReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateReviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
