package com.database.mapper;

import com.database.dto.PersonDto;
import com.database.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toDto(Person person);

    Person toEntity(PersonDto personDto);

}
