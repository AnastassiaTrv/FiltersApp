import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-create-filter-dialog',
  templateUrl: './create-filter-dialog.component.html',
  styleUrls: ['./create-filter-dialog.component.css']
})
export class CreateFilterDialogComponent implements OnInit {

  onSaveSuccess: () => {};

  constructor(private dialogRef: MatDialogRef<CreateFilterDialogComponent>, @Inject(MAT_DIALOG_DATA) data: any) {
    this.onSaveSuccess = data.onSaveSuccess;
  }

  ngOnInit() {
  }

  onFilterCreated() {
    this.onSaveSuccess();
    this.dialogRef.close();
  }

  onCloseBtnClick() {
    this.dialogRef.close();
  }

}
