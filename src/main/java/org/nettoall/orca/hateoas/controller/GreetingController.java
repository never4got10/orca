package org.nettoall.orca.hateoas.controller;

import org.nettoall.orca.hateoas.model.Greeting;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    /**
     * @RequestMapping 모든 Http operation에 매핑됨(GET, POST, PUT, PATCH.,,)
     * @param name
     * @return
     */
    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value= "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        // controller method 에 대한 link 생성과 representationmodel 에 link를 추가하는 방법
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
