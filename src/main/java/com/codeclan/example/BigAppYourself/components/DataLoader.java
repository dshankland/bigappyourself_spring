package com.codeclan.example.BigAppYourself.components;

import com.codeclan.example.BigAppYourself.models.Keyword;
import com.codeclan.example.BigAppYourself.models.User;
import com.codeclan.example.BigAppYourself.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User darren = new User("Darren", "Shankland", "darren@bigappyourself.com", "password" );
        darren.addPreference(Keyword.CODING);
		darren.addPreference(Keyword.FACE);
		darren.addPreference(Keyword.DATABASE);
		darren.generateCompliment();
        userRepository.save(darren);

        User hugh = new User("Hugh", "Jarvis","hugh@bigappyourself.com", "password" );
		hugh.addPreference(Keyword.HAIR);
		hugh.addPreference(Keyword.CHARM);
		hugh.addPreference(Keyword.HUMANITY);
		hugh.generateCompliment();
        userRepository.save(hugh);

        User john = new User("John", "Moir", "john@4bigappyourself.com", "password" );
		john.addPreference(Keyword.KNOWLEDGE);
		john.addPreference(Keyword.STARTUP);
		john.addPreference(Keyword.BEARD);
		john.generateCompliment();
        userRepository.save(john);

    }
}
