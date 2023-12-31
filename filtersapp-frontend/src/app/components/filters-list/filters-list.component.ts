import { Component, OnInit } from '@angular/core';
import { Filter } from 'src/app/model/Filter';
import { FilterService } from 'src/app/service/filter.service';

@Component({
  selector: 'app-filters-list',
  templateUrl: './filters-list.component.html',
  styleUrls: ['./filters-list.component.css']
})
export class FiltersListComponent implements OnInit {

  filters: any;

  constructor(private filterService: FilterService) { }

  ngOnInit() {
    this.load();
  }

  load() {
    this.filterService.getAllFilters()
    .subscribe(
      filters => {
        this.filters = filters;
      },
      error => {
        this.filters = [];
        console.log(error);
      });
  }

  getFiltersCount(): number {
    return this.filters ? this.filters.length : 0
  }

}
