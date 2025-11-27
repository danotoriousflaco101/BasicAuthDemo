package com.flaco.basicauthdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // "/" (http://localhost:8080/)
    @GetMapping("/")
    public String home() {
        return "<h1>Welcome to the zone, everyone can see this spot.</h1>";
    }

    // "/admin" (http://localhost:8080/admin)
    @GetMapping("/admin")
    public String admin() {
        return "<h1>What's good ADMIN!</h1>";
    }
    
    // "/user" (http://localhost:8080/user)
    @GetMapping("/user")
    public String user() {
        return "<h1>Hello there, humble USER.</h1>";
    }
}