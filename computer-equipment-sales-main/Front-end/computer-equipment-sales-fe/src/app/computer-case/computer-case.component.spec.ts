import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComputerCaseComponent } from './computer-case.component';

describe('ComputerCaseComponent', () => {
  let component: ComputerCaseComponent;
  let fixture: ComponentFixture<ComputerCaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComputerCaseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComputerCaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
