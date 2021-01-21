import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainboardAddFormComponent } from './mainboard-add-form.component';

describe('MainboardAddFormComponent', () => {
  let component: MainboardAddFormComponent;
  let fixture: ComponentFixture<MainboardAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainboardAddFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MainboardAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
