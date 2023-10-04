package com.example.service;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.entity.Person;

import jakarta.inject.Singleton;

@Singleton
public class PersonService {
    private List<Person> persons = new ArrayList<>();

    public List<Person> getAllPersons() {
        return persons;
    }

    public Person getPersonById(String id) {
        return persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addPerson(String name, int age) {
        String id = UUID.randomUUID().toString();
        Person person = new Person(id, name, age);
        persons.add(person);
    }

    public void updatePerson(String id, String name, int age) {
        Person existingPerson = getPersonById(id);
        if (existingPerson != null) {
            existingPerson.setName(name);
            existingPerson.setAge(age);
        }
    }

    public void deletePerson(String id) {
        persons.removeIf(person -> person.getId().equals(id));
    }
}
