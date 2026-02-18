package com.github.brunosgs.sevices;

import com.github.brunosgs.data.dto.v1.PersonDTOV1;
import com.github.brunosgs.data.dto.v2.PersonDTOV2;
import com.github.brunosgs.exception.ResourceNotFoundException;
import com.github.brunosgs.mapper.custom.PersonMapper;
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

    @Autowired
    private PersonMapper personMapper;

    public List<PersonDTOV1> findAll() {
        logger.info("Finding all Person!");

        return parseListObjects(personRepository.findAll(), PersonDTOV1.class);
    }

    public PersonDTOV1 findById(Long id) {
        logger.info("Finding one Person!");

        Person person = personRepository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(person, PersonDTOV1.class);
    }

    public PersonDTOV1 create(PersonDTOV1 personDTO) {
        logger.info("Creating one Person V1!");

        Person person = parseObject(personDTO, Person.class);

        return parseObject(personRepository.save(person), PersonDTOV1.class);
    }

    /**
     * Retorna um objeto PersonDTOV2
     *
     * @param personDTO
     * @return PersonDTOV2
     */
    public PersonDTOV2 create(PersonDTOV2 personDTO) {
        logger.info("Creating one Person V2!");

        Person person = personMapper.convertDTOToEntity(personDTO);

        return personMapper.convertEntityToDTO(personRepository.save(person));
    }

    public PersonDTOV1 update(PersonDTOV1 personDTO) {
        logger.info("Updating one Person!");

        PersonDTOV1 findPersonDTO = findById(personDTO.getId());

        findPersonDTO.setFirstName(personDTO.getFirstName());
        findPersonDTO.setLastName(personDTO.getLastName());
        findPersonDTO.setAddress(personDTO.getAddress());
        findPersonDTO.setGender(personDTO.getGender());

        Person person = parseObject(findPersonDTO, Person.class);

        return parseObject(personRepository.save(person), PersonDTOV1.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        PersonDTOV1 personDTO = findById(id);
        Person person = parseObject(personDTO, Person.class);

        personRepository.delete(person);
    }
}
