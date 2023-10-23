import { Pipe, PipeTransform } from '@angular/core';
import { Filter } from '../model/Filter';
import { FilterField } from '../model/FilterField';

@Pipe({
  name: 'filterDescription'
})
export class FilterDescriptionPipe implements PipeTransform {

  transform(f: Filter, ...args: any[]): any {
    return `id: ${f.id}, ${f.name}, ${f.someOptionalValue}, ${this.getFieldsValuesAsString(f.fields)}`;
  }

  getFieldsValuesAsString(fields: FilterField[]) {
    return fields.map(f => f.value).join(', ');
  }

}
