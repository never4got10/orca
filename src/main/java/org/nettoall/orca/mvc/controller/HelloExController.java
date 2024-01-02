package org.nettoall.orca.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloExController {

    @GetMapping("/hi")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
