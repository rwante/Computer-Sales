import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LaptopAddFormComponent } from './laptop-add-form.component';

describe('LaptopAddFormComponent', () => {
  let component: LaptopAddFormComponent;
  let fixture: ComponentFixture<LaptopAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LaptopAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LaptopAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
