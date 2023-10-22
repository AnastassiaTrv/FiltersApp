import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FiltersListComponent } from './components/filters-list/filters-list.component';
import { AddFilterComponent } from './components/add-filter/add-filter.component';
import { AddFilterBtnComponent } from './components/add-filter-btn/add-filter-btn.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    FiltersListComponent,
    AddFilterComponent,
    AddFilterBtnComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
