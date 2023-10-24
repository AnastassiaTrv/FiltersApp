import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddFilterBtnComponent } from './add-filter-btn.component';
import { MatButtonModule, MatCheckboxModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [AddFilterBtnComponent],
  imports: [
    CommonModule,
    MatCheckboxModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    AddFilterBtnComponent
  ]
})
export class AddFilterBtnModule { }
