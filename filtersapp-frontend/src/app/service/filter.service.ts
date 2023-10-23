import { Injectable } from '@angular/core';
import { Filter } from '../model/Filter';
import { HttpClient } from '@angular/common/http';
import { Constants } from '../config/constants';

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  constructor(private http: HttpClient) { }

  getAllFilters(){
    return this.http.get(Constants.API_ENDPOINT_FILTERS);
  }

  saveFilter(filter: Filter) {
    return this.http.post(Constants.API_ENDPOINT_FILTERS, filter)
  }
}
