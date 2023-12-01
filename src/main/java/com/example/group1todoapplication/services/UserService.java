package com.example.group1todoapplication.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.group1todoapplication.dto.UserRegistrationDto;
import com.example.group1todoapplication.models.User;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}