package com.example.springbootapi.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return "Hello friends!";
    }
}
