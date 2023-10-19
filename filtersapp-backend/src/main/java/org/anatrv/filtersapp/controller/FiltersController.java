package org.anatrv.filtersapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.anatrv.filtersapp.model.Filter;
import org.anatrv.filtersapp.model.dto.FilterDto;
import org.anatrv.filtersapp.service.FilterService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public List<FilterDto> getAll() {
        return filterService.getAllFilters()
        .stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
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

    private FilterDto convertToDto(Filter filter) {
        return mapper.map(filter, FilterDto.class);
    }

}