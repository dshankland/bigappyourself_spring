package com.codeclan.example.BigAppYourself.Email;

import com.codeclan.example.BigAppYourself.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailService {

    @Autowired
    SendGridEmailService sendGridEmailService;



    @PostMapping("")
    public void emailCompliment(User user)  {

    }
}
