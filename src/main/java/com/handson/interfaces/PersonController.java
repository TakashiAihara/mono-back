package com.handson.interfaces;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.handson.domain.person.PersonEntity;
import com.handson.domain.person.PersonRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class PersonController {
    private final PersonRepository personRepository;

    @CrossOrigin(origins = "http://ubuntu:8080")
    @GetMapping("/persons")
    public  List<PersonEntity> getPerson(@RequestParam(required = false) String q) {
        if (isNumber(q)) {
            return personRepository.findByNameContainingIgnoreCaseOrId(q,Integer.parseInt(q));
        } else {
            return personRepository.findByNameContainingIgnoreCase(q);
        }
    }

    @CrossOrigin(origins = "http://ubuntu:8080")
    @GetMapping("/persons/{id}")
    public  PersonEntity getPerson(@PathVariable(name = "id") int id) {
            return personRepository.findById(id).get();
    }

    private boolean isNumber(String num) {
        String regex = "^[0-9]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(num);
        return m.find();
    }
}
