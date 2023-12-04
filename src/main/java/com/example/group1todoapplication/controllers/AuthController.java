package com.example.group1todoapplication.controllers;

import com.example.group1todoapplication.dto.UserDto;
import com.example.group1todoapplication.entity.User;
import com.example.group1todoapplication.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") UserDto user,
                    BindingResult result,
                    Model model,
                    HttpServletRequest request) {
    // Validate the user's credentials
    User existingUser = userService.validateUser(user.getEmail(), user.getPassword());

    if (existingUser == null) {
        result.rejectValue("password", null, "Invalid email or password");
        return "login";
    }

    // Create a session or generate an authentication token
    // Here, you can use Spring Security for a more robust solution

    // For session-based authentication
    HttpSession session = request.getSession();
    session.setAttribute("user", existingUser);

    // For token-based authentication
    // Implement token generation and return it to the client
    // Example: String authToken = tokenService.generateToken(existingUser);

    return "redirect:/dashboard"; // Redirect to the home page after successful login
}

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findUserByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
