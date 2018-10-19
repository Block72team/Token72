package com.block72.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jiateng on 10/19/18.
 */
@RestController
public class MainController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
