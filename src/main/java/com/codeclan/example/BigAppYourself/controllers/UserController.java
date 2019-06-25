package com.codeclan.example.BigAppYourself.controllers;

import com.codeclan.example.BigAppYourself.components.ComplimentDispatcher;
import com.codeclan.example.BigAppYourself.models.User;
import com.codeclan.example.BigAppYourself.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ComplimentDispatcher complimentDispatcher;

    @Configuration
    public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.exposeIdsFor(User.class);
        }
    }

    @GetMapping(value = "/compliment/{id}")
    public User updateUserCompliment(@PathVariable(value = "id") Long id) {
        User existingUser = userRepository.findById(id).get();
        existingUser.generateCompliment();
        userRepository.save(existingUser);
        return existingUser;
    }

    @GetMapping(value ="/tweet/{twitterhandle}")
    public void tweetFriendACompliment(@PathVariable(value="twitterhandle")String twitterhandle) throws TwitterException {
        complimentDispatcher.tagAFriendAndTweet(twitterhandle);
    }
}
