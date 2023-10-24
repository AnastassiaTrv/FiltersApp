import { Component, ViewChild } from '@angular/core';
import { FiltersListComponent } from './components/filters-list/filters-list.component';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material';
import { CreateFilterDialogComponent } from './components/create-filter-dialog/create-filter-dialog.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  @ViewChild(FiltersListComponent, { static: false}) filtersList: FiltersListComponent;

  showCreateView = false;

  constructor(private dialog: MatDialog) {} 

  triggerFiltersListReload() {
    this.hideCreateView();
    this.filtersList.load();
  }

  openCreateView(useDialog: boolean) {
    if (useDialog) {
      this.openCreateFilterDialog();
    } else {
      this.openCreateFilterView();
    }
  }

  openCreateFilterDialog(): void { 
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.panelClass = 'create-filter-panel',
    dialogConfig.data = {
      onSaveSuccess: () => this.triggerFiltersListReload()
    };

    this.dialog.open(CreateFilterDialogComponent, dialogConfig); 
  }

  openCreateFilterView() {
    this.showCreateView = true;
  }

  hideCreateView() {
    this.showCreateView = false;
  }
}
