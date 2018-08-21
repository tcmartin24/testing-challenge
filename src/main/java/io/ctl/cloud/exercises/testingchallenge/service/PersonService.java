package io.ctl.cloud.exercises.testingchallenge.service;

import io.ctl.cloud.exercises.testingchallenge.model.Person;
import io.ctl.cloud.exercises.testingchallenge.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAllPeople() {
        return (List<Person>) personRepository.findAll();
    }
}
