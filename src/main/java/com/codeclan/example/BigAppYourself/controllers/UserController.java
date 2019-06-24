package com.codeclan.example.BigAppYourself.controllers;

import com.codeclan.example.BigAppYourself.models.User;
import com.codeclan.example.BigAppYourself.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "/compliment/{id}")
    public User updateUserCompliment(@PathVariable(value = "id") Long id) {
        User existingUser = userRepository.findById(id).get();
        existingUser.generateCompliment();
        userRepository.save(existingUser);
        return existingUser;
    }
}
