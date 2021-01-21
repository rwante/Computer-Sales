import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonitorAddFormComponent } from './monitor-add-form.component';

describe('MonitorAddFormComponent', () => {
  let component: MonitorAddFormComponent;
  let fixture: ComponentFixture<MonitorAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MonitorAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MonitorAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
