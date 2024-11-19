import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllDriverComponent } from '../displayalldriver/displayalldriver.component';

describe('DisplayalldriverComponent', () => {
  let component: DisplayAllDriverComponent;
  let fixture: ComponentFixture<DisplayAllDriverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllDriverComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayAllDriverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
