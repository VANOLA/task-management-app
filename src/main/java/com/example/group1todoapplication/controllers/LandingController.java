package com.example.group1todoapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping("/")
    public String landingPage() {
        return "landing"; // Return the landing page (landing.html)
    }
}
