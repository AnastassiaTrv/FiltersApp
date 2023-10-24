import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFilterDialogComponent } from './create-filter-dialog.component';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogModule, MatDialogRef } from '@angular/material';
import { CreateFilterViewModule } from '../create-filter-view/create-filter-view.module';
import { MockComponent } from 'ng-mocks';
import { CreateFilterViewComponent } from '../create-filter-view/create-filter-view.component';

describe('CreateFilterDialogComponent', () => {
  let component: CreateFilterDialogComponent;
  let fixture: ComponentFixture<CreateFilterDialogComponent>;
  const matDialogRef = jasmine.createSpyObj('MatDialogRef', ['close']);
  const matDialogData = jasmine.createSpyObj('MatDialogData', ['close']);

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFilterDialogComponent, MockComponent(CreateFilterViewComponent) ],
      imports: [
        MatDialogModule,
        CreateFilterViewModule
      ],
      providers: [
        { provide: MatDialogRef, useValue: matDialogRef },
        { provide: MAT_DIALOG_DATA, useValue: matDialogData }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFilterDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
