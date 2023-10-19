package org.anatrv.filtersapp;

import org.anatrv.filtersapp.model.Filter;
import org.anatrv.filtersapp.model.FilterField;
import org.anatrv.filtersapp.model.dto.FieldDto;
import org.anatrv.filtersapp.model.dto.FilterDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FiltersappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiltersappApplication.class, args);
	}

    @Bean
    ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		TypeMap<FilterField, FieldDto> fieldMap = modelMapper.createTypeMap(FilterField.class, FieldDto.class);
		
		fieldMap.addMappings(mapper -> {
			mapper.map(src -> src.getFieldMetadata().getName(), FieldDto::setName);
			mapper.map(src -> src.getFieldMetadata().getRequired(), FieldDto::setRequired);
			mapper.map(src -> src.getFieldMetadata().getType(), FieldDto::setType);
			mapper.map(src -> src.getPropertyCondition().getPropertyId(), FieldDto::setPropertyId);
			mapper.map(src -> src.getPropertyCondition().getConditionId(), FieldDto::setConditionId);
		});

		TypeMap<Filter, FilterDto> filterMap = modelMapper.createTypeMap(Filter.class, FilterDto.class);
		filterMap.addMappings(mapper -> {
			mapper.map(src -> src.getId(), FilterDto::setId);
			mapper.map(src -> src.getDescription(), FilterDto::setDescription);
			mapper.map(src -> src.getFields(), FilterDto::setFields);
		});

		return modelMapper;
	}

}
