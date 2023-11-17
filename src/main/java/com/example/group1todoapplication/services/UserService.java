package com.example.group1todoapplication.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.group1todoapplication.models.User;
import com.example.group1todoapplication.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
