import { Injectable } from "@angular/core";

@Injectable()
export class Constants {
    static readonly API_BASE: string = 'http://localhost:8080/api/';
    static readonly API_ENDPOINT_GET_FILTERS: string = Constants.API_BASE + 'filters'
}