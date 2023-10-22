import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FiltersListComponent } from './filters-list/filters-list.component';
import { AddFilterComponent } from './add-filter/add-filter.component';
import { AddFilterBtnComponent } from './add-filter-btn/add-filter-btn.component';

@NgModule({
  declarations: [
    AppComponent,
    FiltersListComponent,
    AddFilterComponent,
    AddFilterBtnComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
