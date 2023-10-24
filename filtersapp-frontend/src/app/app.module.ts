import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FiltersListModule } from './components/filters-list/filters-list.module';
import { CreateFilterViewModule } from './components/create-filter-view/create-filter-view.module';
import { AddFilterBtnModule } from './components/add-filter-btn/add-filter-btn.module';
import { MatDialogModule } from '@angular/material';
import { CreateFilterDialogModule } from './components/create-filter-dialog/create-filter-dialog.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FiltersListModule,
    CreateFilterViewModule,
    AddFilterBtnModule,
    MatDialogModule,
    CreateFilterDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
