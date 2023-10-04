package com.example.controller;



import java.util.List;

import com.example.entity.Person;
import com.example.service.PersonService;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;

@Controller("/persons")
public class PersonController {

    @Inject
    private PersonService personService;

    @Get("/")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @Get("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.getPersonById(id);
    }

    @Post("/")
    public void addPerson(@Body Person person) {
        personService.addPerson(person.getName(), person.getAge());
    }

    @Put("/{id}")
    public void updatePerson(@PathVariable String id, @Body Person person) {
        personService.updatePerson(id, person.getName(), person.getAge());
    }

    @Delete("/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }
}

