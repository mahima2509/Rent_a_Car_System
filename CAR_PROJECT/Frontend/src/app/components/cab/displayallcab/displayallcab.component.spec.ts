import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllCabComponent } from './displayallcab.component';

describe('DisplayallcabComponent', () => {
  let component: DisplayAllCabComponent;
  let fixture: ComponentFixture<DisplayAllCabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllCabComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayAllCabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
