import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFilterViewComponent } from './create-filter-view.component';

describe('AddFilterComponent', () => {
  let component: CreateFilterViewComponent;
  let fixture: ComponentFixture<CreateFilterViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFilterViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFilterViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
