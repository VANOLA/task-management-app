package com.example.group1todoapplication.services;

import com.example.group1todoapplication.dto.UserDto;
import com.example.group1todoapplication.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

    User validateUser(String firstName, String password);
}