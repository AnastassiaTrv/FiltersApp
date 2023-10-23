import { FilterField } from "./FilterField";

export class Filter {
    id: number
    name: string;
    someOptionalValue: string;
    fields: FilterField[];
}