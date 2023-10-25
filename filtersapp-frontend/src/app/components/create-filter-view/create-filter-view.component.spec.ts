import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFilterViewComponent } from './create-filter-view.component';
import { MockComponent } from 'ng-mocks';
import { ErrorMessageComponent } from '../error-message/error-message.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatDatepickerModule, MatIconModule, MatInputModule, MatListModule, MatNativeDateModule, MatRadioModule, MatSelectModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { FilterService } from 'src/app/service/filter.service';
import { Observable } from 'rxjs';

describe('AddFilterComponent', () => {
  let component: CreateFilterViewComponent;
  let fixture: ComponentFixture<CreateFilterViewComponent>;
  const filterService = {
    getFilterPropertyConditions: () => {
      return new Observable();
    }
  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFilterViewComponent, MockComponent(ErrorMessageComponent) ],
      imports: [
        BrowserAnimationsModule,
        MatInputModule,
        MatListModule,
        MatSelectModule,
        MatButtonModule,
        MatIconModule,
        MatRadioModule,
        MatDatepickerModule,
        MatNativeDateModule,
        FormsModule
      ],
      providers: [
        { provide: FilterService, useValue: filterService }
      ]
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
