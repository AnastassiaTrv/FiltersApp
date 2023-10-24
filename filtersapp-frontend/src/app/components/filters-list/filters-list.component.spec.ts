import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FiltersListComponent } from './filters-list.component';
import { MockPipe, MockService } from 'ng-mocks';
import { FilterDescriptionPipe } from 'src/app/pipes/filter-description.pipe';
import { FilterService } from 'src/app/service/filter.service';
import { Observable } from 'rxjs';

describe('FiltersListComponent', () => {
  let component: FiltersListComponent;
  let fixture: ComponentFixture<FiltersListComponent>;
  const filterService = {
    getAllFilters: () => {
      return new Observable();
    }
  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FiltersListComponent, MockPipe(FilterDescriptionPipe) ],
      providers: [
        { provide: FilterService, useValue: filterService }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FiltersListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
