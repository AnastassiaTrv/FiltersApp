package org.anatrv.filtersapp.service;

import java.util.List;
import java.util.Optional;

import org.anatrv.filtersapp.model.Filter;
import org.anatrv.filtersapp.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterService {

    @Autowired
    private FilterRepository filterRepository;

    public List<Filter> getAllFilters() {
        return filterRepository.findAll();
    }

    public Optional<Filter> getOneById(Integer id) {
        return filterRepository.findById(id);
    }

    public void update(Filter filter) {
        filterRepository.save(filter);
    }

    public Filter createFilter(Filter filter) {
        return filterRepository.save(filter);
    }
    
}
