package com.example.Bus.Manager;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloClass {
    @RequestMapping(value = "/lockmanager", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello, World!";
    }
}
