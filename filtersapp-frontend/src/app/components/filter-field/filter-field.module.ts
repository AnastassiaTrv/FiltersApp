import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilterFieldComponent } from './filter-field.component';



@NgModule({
  declarations: [FilterFieldComponent],
  imports: [
    CommonModule
  ],
  exports: [
    FilterFieldComponent
  ]
})
export class FilterFieldModule { }
