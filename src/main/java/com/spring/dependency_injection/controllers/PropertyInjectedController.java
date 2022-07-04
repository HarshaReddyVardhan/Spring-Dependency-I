package com.spring.dependency_injection.controllers;

import com.spring.dependency_injection.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Autowired
    public GreetingsService greetingsService;

    public String getGreeting() {
        return greetingsService.sayGreetings();
    }
}
