import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable()
export class Constants {
    static readonly API_ENDPOINT_FILTERS: string = environment.apiBaseUrl + 'filters';
    static readonly API_ENDPOINT_PROPERTY_CONDITIONS: string = environment.apiBaseUrl + 'property-conditions';
}