import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RamAddFormComponent } from './ram-add-form.component';

describe('RamAddFormComponent', () => {
  let component: RamAddFormComponent;
  let fixture: ComponentFixture<RamAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RamAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RamAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
