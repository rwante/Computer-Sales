import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayCardAddFormComponent } from './display-card-add-form.component';

describe('DisplayCardAddFormComponent', () => {
  let component: DisplayCardAddFormComponent;
  let fixture: ComponentFixture<DisplayCardAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayCardAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayCardAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
