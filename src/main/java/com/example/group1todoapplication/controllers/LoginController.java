package com.example.group1todoapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.group1todoapplication.repositories.UserRepository;
import com.example.group1todoapplication.models.User;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // TODO fix this mapping
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
//        Optional<User> user = userRepository.findByEmail(email);
        User user = userRepository.findByEmail(email);

//        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "redirect:/home";
//        } else {
//            model.addAttribute("error", "Invalid email or password");
//            return "login";
//        }
    }
}
