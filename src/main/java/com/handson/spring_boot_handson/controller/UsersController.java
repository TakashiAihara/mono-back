package com.handson.spring_boot_handson.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsersController {

    @GetMapping("/test")
    // public String getMethodName(@RequestParam String param) {
    public String get() {
        return "test";
    }
}
