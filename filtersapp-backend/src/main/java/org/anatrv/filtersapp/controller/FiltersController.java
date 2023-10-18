package org.anatrv.filtersapp.controller;

import java.util.Collection;

import org.anatrv.filtersapp.model.Filter;
import org.anatrv.filtersapp.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
@RequestMapping(path = "api/filters", produces = "application/json")
public class FiltersController {

    @Autowired
    private FilterService filterService;

    @GetMapping
    public Collection<Filter> getAll() {
        return filterService.getAllFilters();
    }

    public Filter getById(Integer id) {
        return null;
    }

    public Integer create(Filter filter) {
        return 1;
    }

    public void updateById(Integer id, Filter filter) {

    }

    public void deleteById(Integer id) {

    }

}