import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCabComponent } from './updatecab.component';

describe('UpdatecabComponent', () => {
  let component: UpdateCabComponent;
  let fixture: ComponentFixture<UpdateCabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCabComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateCabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
