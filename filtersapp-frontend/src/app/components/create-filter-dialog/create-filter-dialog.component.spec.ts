import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFilterDialogComponent } from './create-filter-dialog.component';

describe('CreateFilterDialogComponent', () => {
  let component: CreateFilterDialogComponent;
  let fixture: ComponentFixture<CreateFilterDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFilterDialogComponent ]
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
