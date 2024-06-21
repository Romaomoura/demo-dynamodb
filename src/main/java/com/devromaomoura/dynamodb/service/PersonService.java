package com.devromaomoura.dynamodb.service;

import com.devromaomoura.dynamodb.domain.Person;
import com.devromaomoura.dynamodb.exception.DynamoDBDefaultException;
import com.devromaomoura.dynamodb.record.PersonRecord;
import com.devromaomoura.dynamodb.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonRecord save(PersonRecord personRecord) {
        Person person = new Person(null, personRecord.name(), personRecord.age());
        personRepository.save(person);
        return personRecord;
    }

    public PersonRecord getPerson(String id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new DynamoDBDefaultException("Person not found!"));
        return new PersonRecord(person.getId(), person.getName(), person.getAge());
    }

    public void deleteById(String id) {
        if (this.getPerson(id) != null) {
            personRepository.deleteById(id);
        }
    }
}
