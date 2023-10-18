package org.anatrv.filtersapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.anatrv.filtersapp.model.Filter;
import org.springframework.stereotype.Service;

@Service
public class FilterService {

    public Collection<Filter> getAllFilters() {
        Filter simpleFilter = new Filter();
        simpleFilter.setId(123);
        simpleFilter.setName("Simple");
        return new ArrayList<>(Arrays.asList(simpleFilter));
    }
    
}
