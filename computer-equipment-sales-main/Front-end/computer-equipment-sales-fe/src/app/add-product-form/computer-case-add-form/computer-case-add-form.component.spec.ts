import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComputerCaseAddFormComponent } from './computer-case-add-form.component';

describe('ComputerCaseAddFormComponent', () => {
  let component: ComputerCaseAddFormComponent;
  let fixture: ComponentFixture<ComputerCaseAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComputerCaseAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComputerCaseAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
