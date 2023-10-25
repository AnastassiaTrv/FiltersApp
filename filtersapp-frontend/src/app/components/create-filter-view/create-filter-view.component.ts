import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { format } from 'date-fns';
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

  @Output() onFilterCreated = new EventEmitter<void>();
  @Output() onCloseBtnClick = new EventEmitter<void>();

  filter: Filter;
  propertyConditionsList: any;
  errorMsg: string;

  constructor(private filterService: FilterService) { }

  ngOnInit() {
    this.filter = new Filter();
    this.filter.someOptionalValue = 'Winter';
    this.filter.fields = [];
    this.fetchPropertyConditions();
  }

  fetchPropertyConditions() {
    this.filterService.getFilterPropertyConditions()
    .subscribe(
      pcList => {
        this.propertyConditionsList = pcList;
        this.addDefaultField();
      },
      error => {
        this.propertyConditionsList = [];
        console.log(error);
      });
  }

  addDefaultField() {
    this.filter.fields.push(this.createDefaultField());
  }

  createDefaultField(): FilterField {
    return { propertyId: 1 }; // first property should be preselected
  }

  removeField(index: number) {
    this.filter.fields.splice(index, 1);
  }

  loadPropertyConditions(propertyId: number): Condition[] {
    return this.findPropertyConditionsById(propertyId).conditions;
  }

  isDateProperty(propertyId: number) {
    return this.findPropertyConditionsById(propertyId).property.dataType === 'date';
  }

  findPropertyConditionsById(propertyId: number): PropertyConditions  {
    return this.propertyConditionsList.find(elem => elem.property.id === propertyId);
  }

  formatAndSetDateValue(field: FilterField, date: any) {
    field.value = format(date.value, 'yyyy-MM-dd');
  }

  saveFilter() {
    this.filterService.saveFilter(this.filter)
    .subscribe(
      saved => {
        this.errorMsg = null;
        this.onFilterCreated.emit();
      },
      e => {
        this.errorMsg = e.error.message;
      });
  }

  closeView() {
    this.onCloseBtnClick.emit();
  }

}
