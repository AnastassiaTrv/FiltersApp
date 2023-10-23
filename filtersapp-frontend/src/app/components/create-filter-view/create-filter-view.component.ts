import { Component, Input, OnInit } from '@angular/core';
import { Condition } from 'src/app/model/Condition';
import { Filter } from 'src/app/model/Filter';
import { FilterField } from 'src/app/model/FilterField';
import { PropertyConditions } from 'src/app/model/PropertyCondition';
import { FilterService } from 'src/app/service/filter.service';

@Component({
  selector: 'app-create-filter-view',
  templateUrl: './create-filter-view.component.html',
  styleUrls: ['./create-filter-view.component.css']
})
export class CreateFilterViewComponent implements OnInit {

  filter: Filter;
  propertyConditionsList: PropertyConditions[];

  constructor(private filterService: FilterService) { }

  ngOnInit() {
    this.filter = new Filter();
    this.filter.fields = [ this.createDefaultField() ];
    this.propertyConditionsList = [
      {
        property: {
          id: 1,
          name: 'Amount'
        },
        conditions: [
          { id: 1, rule: 'More'},
          { id: 2, rule: 'Less'},
          { id: 3, rule: 'Equal'},
        ]
      },
      {
        property: {
          id: 2,
          name: 'Title'
        },
        conditions: [
          { id: 3, rule: 'Equal'},
          { id: 4, rule: 'Starts with'},
          { id: 5, rule: 'Ends with'},
          { id: 6, rule: 'Contains'}
        ]
      },
      {
        property: {
          id: 3,
          name: 'Date'
        },
        conditions: [
          { id: 3, rule: 'Equal'},
          { id: 7, rule: 'From'},
          { id: 8, rule: 'Before'}
        ]
      }
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
    this.filter.fields.push(this.createDefaultField());
  }

  removeField(index: number) {
    this.filter.fields.splice(index, 1);
  }

  loadPropertyConditions(propertyId: number): Condition[] {
    return this.propertyConditionsList.find(elem => elem.property.id === propertyId).conditions;
  }

  saveFilter() {
    this.filterService.saveFilter(this.filter).subscribe();
  }

}
