import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilterDescriptionPipe } from './filter-description.pipe';



@NgModule({
  declarations: [FilterDescriptionPipe],
  imports: [
    CommonModule
  ],
  exports: [
    FilterDescriptionPipe
  ]
})
export class FilterPipesModule { }
