import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFilterBtnComponent } from './add-filter-btn.component';
import { MatButtonModule, MatCheckbox, MatCheckboxModule } from '@angular/material';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

describe('AddFilterBtnComponent', () => {
  let component: AddFilterBtnComponent;
  let fixture: ComponentFixture<AddFilterBtnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFilterBtnComponent ],
      imports: [
        MatCheckboxModule,
        MatButtonModule,
        FormsModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFilterBtnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
