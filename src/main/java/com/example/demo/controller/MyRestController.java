package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Base path for all endpoints in this controller
public class MyRestController {

    @GetMapping("/greet/{name}")
    public String greetPerson(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // A GET endpoint with path variable to greet a specific person
    @GetMapping("/greet")
    public String greetPerson(@RequestParam String name, @RequestParam(required = false, defaultValue = "Guest") String role) {
        return "Hello, " + name + "! Your role is " + role + ".";
    }

    // A simple GET endpoint to get the current time
    @GetMapping("/time")
    public String getCurrentTime() {
        return "Current time is: " + System.currentTimeMillis();
    }
}
