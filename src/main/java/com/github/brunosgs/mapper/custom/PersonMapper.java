package com.github.brunosgs.mapper.custom;

import com.github.brunosgs.data.dto.v2.PersonDTOV2;
import com.github.brunosgs.model.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Mapper criado como forma de aprendizado, onde a entidade 'Person' não teve a implementação do
 * campo birthday.
 */
@Component
public class PersonMapper {
    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(LocalDate.now());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 personDTO) {
        Person entity = new Person();

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        //entity.setBirthDay(LocalDate.now());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());

        return entity;
    }
}
