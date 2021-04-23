package com.handson.spring_boot_handson.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.handson.spring_boot_handson.domain.models.User;
import com.handson.spring_boot_handson.domain.repositories.UserRepository;


@AllArgsConstructor
@RestController
public class UsersController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public  List<User> getMethodName(@RequestParam(required = false) String q) {
        if (isNumber(q)) {
            return userRepository.findByNameContainingOrId(q,Integer.parseInt(q));
        } else {
            return userRepository.findByNameContaining(q);
        }
    }

    private boolean isNumber(String num) {
        String regex = "^[0-9]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(num);
        return m.find();
    }
}
