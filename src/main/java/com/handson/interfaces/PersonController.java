package com.handson.interfaces;

import com.handson.domain.person.PersonEntity;
import com.handson.application.PersonService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://ubuntu:8080")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/person/{id}")
    public PersonEntity getPerson(@PathVariable(name = "id") int id) {
        return personService.find(id);
    }

    @PostMapping("/person/create")
    public PersonEntity createPerson(@RequestBody PersonEntity personEntity) {
        return personService.create(personEntity);
    }

    @PutMapping("/person/{id}/update")
    public PersonEntity updatePerson(@PathVariable(name = "id") int id, @RequestBody PersonEntity personEntity) {
        personEntity.setId(id);
        return personService.update(personEntity);
    }

    @DeleteMapping("/person/{id}/delete")
    public boolean deletePerson(@PathVariable(name = "id") int id) {
        try {
            personService.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
