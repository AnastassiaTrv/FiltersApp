package org.anatrv.filtersapp;

import org.anatrv.filtersapp.model.FilterField;
import org.anatrv.filtersapp.model.dto.FieldDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
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
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		// Field entity to FieldDto type map
		modelMapper.createTypeMap(FilterField.class, FieldDto.class).addMappings(mapper -> {
			mapper.map(src -> src.getFieldMetadata().getId(), FieldDto::setKey);
			mapper.map(src -> src.getPropertyCondition().getPropertyId(), FieldDto::setPropertyId);
			mapper.map(src -> src.getPropertyCondition().getConditionId(), FieldDto::setConditionId);
			mapper.map(src -> src.getFieldMetadata().getName(), FieldDto::setName);
		});

		// FieldDto to Field entity type map
		modelMapper.createTypeMap(FieldDto.class, FilterField.class).addMappings(mapper -> {
			mapper.<Integer>map(src -> src.getKey(), (dest, v) -> dest.getFieldMetadata().setId(v));
			mapper.<Integer>map(src -> src.getPropertyId(), (dest, v) -> dest.getPropertyCondition().setPropertyId(v));
			mapper.<Integer>map(src -> src.getConditionId(), (dest, v) -> dest.getPropertyCondition().setConditionId(v));
		});

		return modelMapper;
	}

}
