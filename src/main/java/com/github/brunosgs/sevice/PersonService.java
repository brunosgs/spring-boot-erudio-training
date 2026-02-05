package com.github.brunosgs.sevice;

import com.github.brunosgs.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("João");
        person.setLastName("Da Silva");
        person.setAddress("Florianópolis - Santa Catarina");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);

            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Fist Name " + i);
        person.setLastName("Last Name" + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Gender " + i);

        return person;
    }
}
