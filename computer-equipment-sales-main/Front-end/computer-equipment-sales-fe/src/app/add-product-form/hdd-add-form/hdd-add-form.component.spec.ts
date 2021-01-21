import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HddAddFormComponent } from './hdd-add-form.component';

describe('HddAddFormComponent', () => {
  let component: HddAddFormComponent;
  let fixture: ComponentFixture<HddAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HddAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HddAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
