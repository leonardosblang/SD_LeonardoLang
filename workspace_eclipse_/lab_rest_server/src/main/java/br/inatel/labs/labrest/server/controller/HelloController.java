package br.inatel.labs.labrest.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public MyMessage processGetHello() {
        return new MyMessage("Hello, REST world!");
    }
}
