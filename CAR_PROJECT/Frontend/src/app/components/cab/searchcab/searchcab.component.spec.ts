import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchcabComponent } from './searchcab.component';

describe('SearchcabComponent', () => {
  let component: SearchcabComponent;
  let fixture: ComponentFixture<SearchcabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchcabComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchcabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
