import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FiltersListComponent } from './filters-list.component';
import { FilterPipesModule } from 'src/app/pipes/filter-pipes.module';



@NgModule({
  declarations: [FiltersListComponent],
  imports: [
    CommonModule,
    FilterPipesModule
  ],
  exports: [
    FiltersListComponent
  ]
})
export class FiltersListModule { }
