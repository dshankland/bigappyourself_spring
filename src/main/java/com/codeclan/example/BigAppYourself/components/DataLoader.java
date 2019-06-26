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

        User darren = new User("Darren", "Shankland", "ds@4pq.co.uk", "password" );
        darren.setTwitter("@darrenshankland");
        darren.setPhone("+447967219233");
        darren.addPreference(Keyword.CODING);
		darren.addPreference(Keyword.FACE);
		darren.addPreference(Keyword.DATABASE);
		darren.generateCompliment();
        userRepository.save(darren);

        User hugh = new User("Hugh", "Jarvis","hugh.jarvis@blueyonder.co.uk", "password" );
		hugh.setTwitter("@hughdjarvis");
		hugh.setPhone("+447813684853");
        hugh.addPreference(Keyword.HAIR);
		hugh.addPreference(Keyword.CHARM);
		hugh.addPreference(Keyword.BIKE);
		hugh.generateCompliment();
        userRepository.save(hugh);

        User john = new User("John", "Moir", "jmmoir@outlook.com", "password" );
        john.setPhone("+447894114326");
		john.addPreference(Keyword.KNOWLEDGE);
		john.addPreference(Keyword.STARTUP);
		john.addPreference(Keyword.BEARD);
		john.generateCompliment();
        userRepository.save(john);

    }
}
