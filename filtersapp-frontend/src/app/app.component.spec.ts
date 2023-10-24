import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { MockComponents } from 'ng-mocks';
import { AddFilterBtnComponent } from './components/add-filter-btn/add-filter-btn.component';
import { CreateFilterViewComponent } from './components/create-filter-view/create-filter-view.component';
import { FiltersListComponent } from './components/filters-list/filters-list.component';
import { MatDialog } from '@angular/material';

describe('AppComponent', () => {
  const matDialog = jasmine.createSpyObj('MatDialog', ['open']);

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent, MockComponents(AddFilterBtnComponent, CreateFilterViewComponent, FiltersListComponent)
      ],
      providers: [
        { provide: MatDialog, useValue: matDialog }
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });
});
