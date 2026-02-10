package com.github.brunosgs.sevices;

import com.github.brunosgs.exception.ResourceNotFoundException;
import com.github.brunosgs.model.Person;
import com.github.brunosgs.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("Finding all Person!");

        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");

        return personRepository.findById(id)
                               .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");

        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");

        Person findPerson = findById(person.getId());

        findPerson.setFirstName(person.getFirstName());
        findPerson.setLastName(person.getLastName());
        findPerson.setAddress(person.getAddress());
        findPerson.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person person = findById(id);

        personRepository.delete(person);
    }
}
