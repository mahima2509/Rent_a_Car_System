import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchreviewComponent } from './searchreview.component';

describe('SearchreviewComponent', () => {
  let component: SearchreviewComponent;
  let fixture: ComponentFixture<SearchreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchreviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
