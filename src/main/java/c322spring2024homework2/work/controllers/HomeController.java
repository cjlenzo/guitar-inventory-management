package c322spring2024homework2.work.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greetings(){
        return "Welcome to the guitar inventory service!";
    }
}