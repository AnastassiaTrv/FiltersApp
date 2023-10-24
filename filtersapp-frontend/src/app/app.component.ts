import { Component, ViewChild } from '@angular/core';
import { FiltersListComponent } from './components/filters-list/filters-list.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'filtersapp-frontend';

  @ViewChild(FiltersListComponent, { static: false}) filtersList: FiltersListComponent;

  triggerFiltersListReload() {
    this.filtersList.load();
  }
}
