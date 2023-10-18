package org.anatrv.filtersapp.service;

import org.anatrv.filtersapp.model.Filter;
import org.anatrv.filtersapp.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterService {

    @Autowired
    private FilterRepository filterRepository;

    public Iterable<Filter> getAllFilters() {
        return filterRepository.findAll();
    }
    
}
