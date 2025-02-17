import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDriverComponent } from './updatedriver.component';

describe('UpdatedriverComponent', () => {
  let component: UpdateDriverComponent;
  let fixture: ComponentFixture<UpdateDriverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateDriverComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateDriverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
