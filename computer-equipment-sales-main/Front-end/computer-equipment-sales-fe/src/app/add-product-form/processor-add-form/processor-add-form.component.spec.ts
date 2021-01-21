import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessorAddFormComponent } from './processor-add-form.component';

describe('ProcessorAddFormComponent', () => {
  let component: ProcessorAddFormComponent;
  let fixture: ComponentFixture<ProcessorAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProcessorAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcessorAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
