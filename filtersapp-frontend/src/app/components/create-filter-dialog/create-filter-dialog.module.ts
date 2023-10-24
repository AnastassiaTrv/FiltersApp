import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateFilterDialogComponent } from './create-filter-dialog.component';
import { CreateFilterViewModule } from '../create-filter-view/create-filter-view.module';
import { MatDialogModule } from '@angular/material';



@NgModule({
  declarations: [CreateFilterDialogComponent],
  imports: [
    CommonModule,
    MatDialogModule,
    CreateFilterViewModule
  ],
  entryComponents: [CreateFilterDialogComponent]
})
export class CreateFilterDialogModule { }
