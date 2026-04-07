package com.github.brunosgs.controllers;

import com.github.brunosgs.data.dto.v1.PersonDTOV1;
import com.github.brunosgs.data.dto.v2.PersonDTOV2;
import com.github.brunosgs.sevices.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/v1/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 findById(@PathVariable Long id) {
        PersonDTOV1 personById = personService.findById(id);

        personById.setBirthDay(LocalDate.now());

        return personById;
    }

    @GetMapping(value = "v1",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTOV1> findAll() {
        return personService.findAll();
    }

    @PostMapping(value = "v1",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 create(@RequestBody PersonDTOV1 person) {
        return personService.create(person);
    }

    @PostMapping(value = "v2",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
        return personService.create(person);
    }

    @PutMapping(value = "v1",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 update(@RequestBody PersonDTOV1 person) {
        return personService.update(person);
    }

    @DeleteMapping(value = "v1/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
