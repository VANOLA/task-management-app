package com.example.group1todoapplication.controllers;

import com.example.group1todoapplication.dto.UserRegistrationDto;
import com.example.group1todoapplication.models.TodoItem;
import com.example.group1todoapplication.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/login") //TODO Fix mappings in this controller
public class RegistrationController {
    private UserServiceImpl userService;

    public RegistrationController(UserServiceImpl userService) {
        super();
        this.userService = userService;
    }

@ModelAttribute("user")
public UserRegistrationDto userRegistrationDto() {
    return new UserRegistrationDto();
}

@PostMapping("/register-user")
public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
    userService.save(registrationDto);
    return "redirect:/registration?success";
}
}
