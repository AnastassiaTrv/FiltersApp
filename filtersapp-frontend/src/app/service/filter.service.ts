import { Injectable } from '@angular/core';
import { Filter } from '../model/Filter';
import { HttpClient } from '@angular/common/http';
import { error } from 'console';
import { Constants } from '../config/constants';

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  constructor(private http: HttpClient) { }

  getAllFilters(){
    return this.http.get(Constants.API_ENDPOINT_GET_FILTERS);
  }

  createFilter(f: Filter) {

  }
}
