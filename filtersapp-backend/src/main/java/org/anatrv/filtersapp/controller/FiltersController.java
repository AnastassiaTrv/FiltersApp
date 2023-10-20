package org.anatrv.filtersapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.anatrv.filtersapp.exception.ResourceNotFoundException;
import org.anatrv.filtersapp.model.Filter;
import org.anatrv.filtersapp.model.dto.FilterDto;
import org.anatrv.filtersapp.service.FilterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public FilterDto getById(@PathVariable("id") Integer id) {
        return filterService.getOneById(id)
        .map(this::convertToDto)
        .orElseThrow( () -> new ResourceNotFoundException());
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer create(@Valid @RequestBody FilterDto filterDto) {
        return filterService.createFilter(convertToEntity(filterDto));
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public void updateById(Integer id, Filter filter) {
        
    }

    public void deleteById(@PathVariable("id") Integer id, @RequestBody FilterDto filterDto) {

    }

    private FilterDto convertToDto(Filter filter) {
        return mapper.map(filter, FilterDto.class);
    }

    private Filter convertToEntity(FilterDto filter) {
        return mapper.map(filter, Filter.class);
    }

}