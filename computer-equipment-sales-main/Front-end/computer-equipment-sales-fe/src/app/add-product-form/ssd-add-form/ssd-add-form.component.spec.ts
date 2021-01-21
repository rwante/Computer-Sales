import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SsdAddFormComponent } from './ssd-add-form.component';

describe('SsdAddFormComponent', () => {
  let component: SsdAddFormComponent;
  let fixture: ComponentFixture<SsdAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SsdAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SsdAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
