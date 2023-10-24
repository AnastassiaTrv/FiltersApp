import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateFilterViewComponent } from './create-filter-view.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatIconModule, MatInputModule, MatListModule, MatRadioModule, MatSelectModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ErrorMessageModule } from '../error-message/error-message.module';



@NgModule({
  declarations: [CreateFilterViewComponent],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatListModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule,
    MatRadioModule,
    FormsModule,
    ReactiveFormsModule,
    ErrorMessageModule
  ],
  exports: [
    CreateFilterViewComponent
  ]
})
export class CreateFilterViewModule { }
