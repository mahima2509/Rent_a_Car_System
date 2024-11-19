import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCabComponent } from './addcab.component';

describe('AddcabComponent', () => {
  let component: AddCabComponent;
  let fixture: ComponentFixture<AddCabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCabComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
