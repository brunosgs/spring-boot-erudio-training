package com.github.brunosgs.sevices;

import com.github.brunosgs.data.dto.PersonDTO;
import com.github.brunosgs.exception.ResourceNotFoundException;
import com.github.brunosgs.model.Person;
import com.github.brunosgs.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.brunosgs.mapper.ObjectMapper.parseListObjects;
import static com.github.brunosgs.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {
    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDTO> findAll() {
        logger.info("Finding all Person!");

        return parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        Person person = personRepository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(person, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating one Person!");

        Person person = parseObject(personDTO, Person.class);

        return parseObject(personRepository.save(person), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Updating one Person!");

        PersonDTO findPersonDTO = findById(personDTO.getId());

        findPersonDTO.setFirstName(personDTO.getFirstName());
        findPersonDTO.setLastName(personDTO.getLastName());
        findPersonDTO.setAddress(personDTO.getAddress());
        findPersonDTO.setGender(personDTO.getGender());

        Person person = parseObject(findPersonDTO, Person.class);

        return parseObject(personRepository.save(person), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        PersonDTO personDTO = findById(id);
        Person person = parseObject(personDTO, Person.class);

        personRepository.delete(person);
    }
}
