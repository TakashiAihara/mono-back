package com.handson.interfaces;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.handson.domain.person.PersonEntity;
import com.handson.application.PersonService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://ubuntu:8080")
public class PersonsController {
    private final PersonService personService;

    @GetMapping("/persons")
    public  List<PersonEntity> getPersons(@RequestParam(required = false) String q) {
        if (isNumber(q)) {
            return personService.findByNameId(q,Integer.parseInt(q));
        } else {
            return personService.findByName(q);
        }
    }

    private boolean isNumber(String num) {
        String regex = "^[0-9]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(num);
        return m.find();
    }
}
