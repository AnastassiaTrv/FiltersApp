package org.anatrv.filtersapp.controller;

import java.util.List;

import org.anatrv.filtersapp.exception.ResourceNotFoundException;
import org.anatrv.filtersapp.model.Filter;
import org.anatrv.filtersapp.model.dto.FilterDto;
import org.anatrv.filtersapp.service.FilterService;
import org.anatrv.filtersapp.service.FilterValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
@CrossOrigin
@RestController
@RequestMapping(path = "api/filters", produces = "application/json")
public class FiltersController {

    @Autowired
    private FilterService filterService;

    @Autowired
    private FilterValidationService validationService;

    @Autowired
    private ModelMapper mapper;

    @InitBinder(value = "filterDto")
    void initFiltertValidator(WebDataBinder binder) {
        binder.setValidator(validationService);
    }

    @GetMapping
    public List<FilterDto> getAll() {
        return filterService.getAllFilters()
        .stream()
        .map(this::convertToDto)
        .toList(); // Java 17 finally has it!
    }

    @GetMapping("/{id}")
    public FilterDto getById(@PathVariable("id") Integer id) {
        return filterService.getOneById(id)
        .map(this::convertToDto)
        .orElseThrow( () -> new ResourceNotFoundException());
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public FilterDto create(@Valid @RequestBody FilterDto filterDto) {
        Filter created = filterService.createFilter(convertToEntity(filterDto));
        return convertToDto(created);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED, reason = "unable to update resource, not implemented")
    public void updateById(@PathVariable("id") Integer id, @RequestBody FilterDto filter) {
        
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED, reason = "unable to delete resource, not implemented")
    public void deleteById(@PathVariable("id") Integer id) {

    }

    private FilterDto convertToDto(Filter filter) {
        return mapper.map(filter, FilterDto.class);
    }

    private Filter convertToEntity(FilterDto filter) {
        return mapper.map(filter, Filter.class);
    }

}