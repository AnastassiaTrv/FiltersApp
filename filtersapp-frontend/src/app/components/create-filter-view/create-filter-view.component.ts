import { Component, Input, OnInit } from '@angular/core';
import { Filter } from 'src/app/model/Filter';
import { FilterField } from 'src/app/model/FilterField';

@Component({
  selector: 'app-create-filter-view',
  templateUrl: './create-filter-view.component.html',
  styleUrls: ['./create-filter-view.component.css']
})
export class CreateFilterViewComponent implements OnInit {

  filter: Filter;
  properties: any[];
  conditions: any[];

  constructor() { }

  ngOnInit() {
    this.filter = new Filter();
    this.filter.fileds = [ this.createDefaultField(), this.createDefaultField() ];

    this.properties = [
      { id: 1, name: 'Amount'},
      { id: 2, name: 'Title'},
      { id: 3, name: 'Date'}
    ]

    this.conditions = [
      { id: 1, name: 'More'},
      { id: 2, name: 'Less'},
      { id: 3, name: 'Equal'}
    ]
  }

  createDefaultField(): FilterField {
    const field = {
      id: null,
      propertyId: 1,
      conditionId: 1,
      value: 'test'
    }
    return field;
  }

  addNewField() {
    this.filter.fileds.push(this.createDefaultField());
  }

  removeField(index: number) {
    this.filter.fileds.splice(index, 1);
  }

}
