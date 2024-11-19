import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchdriverComponent } from './searchdriver.component';

describe('SearchdriverComponent', () => {
  let component: SearchdriverComponent;
  let fixture: ComponentFixture<SearchdriverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchdriverComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchdriverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
