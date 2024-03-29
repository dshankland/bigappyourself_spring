package com.codeclan.example.BigAppYourself.components;

import com.codeclan.example.BigAppYourself.Email.SendGridEmailService;
import com.codeclan.example.BigAppYourself.SMS.SmsSender;
import com.codeclan.example.BigAppYourself.models.Keyword;
import com.codeclan.example.BigAppYourself.models.Modifier;
import com.codeclan.example.BigAppYourself.models.Superlative;
import com.codeclan.example.BigAppYourself.models.User;
import com.codeclan.example.BigAppYourself.repositories.UserRepository;
import com.codeclan.example.BigAppYourself.twitter.TwitterApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EnableScheduling
@Service
@Component
public class ComplimentDispatcher {

    @Autowired
    SmsSender smsSender;

    @Autowired
    TwitterApp twitterApp;

    @Autowired
    SendGridEmailService sendGridEmailService;

    @Autowired
    UserRepository userRepository;

    private List<User> users;

    public ComplimentDispatcher() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void getAllUsers(){
        this.users = userRepository.findAll();
        System.out.println(this.users);
    }

    @Scheduled(cron = "0 0 7 * * ?")
    @Scheduled(cron = "0 53 14 * * ?")
    @Scheduled(cron = "0 0 17 * * ?")
    @Scheduled(cron = "0 0 22 * * ?")
    public void sendCompliments() throws TwitterException {
        getAllUsers();
        for (User user : users){
            if (user.getEmail().length() >= 3){
                user.generateCompliment();
                sendGridEmailService.send(user.generateComplimentEmail());
            }
            if (user.getTwitter() != null){
                user.generateCompliment();
                twitterApp.sendDirectMessage(user.getTwitter(), user.getCompliment());
            }
            if (user.getPhone() != null){
                user.generateCompliment();
                smsSender.sendSMS(user);
            }
        }
    }

    @Scheduled(cron = "0 0 7 * * ?")
    @Scheduled(cron = "0 0 12 * * ?")
    @Scheduled(cron = "0 0 17 * * ?")
    @Scheduled(cron = "0 0 22 * * ?")
    public void broadcastTweet() throws TwitterException {
        TwitterApp.createTweet(generateCompliment()+" #NiceApp #BigAppYourself #Compliments #Praise");

    }

    public String generateCompliment(){
        Modifier randomModifier = Modifier.getRandom();
        Keyword randomKeyword = Keyword.getRandom();
        Superlative superlative = Superlative.getRandom();
        String complimentStart = "Your " + randomKeyword.name().toLowerCase() + " " + randomKeyword.getkeywordTextFragFromEnum() + " ";
        if (randomKeyword == Keyword.GENERAL) {
            complimentStart = "You are ";
        }
        String compliment = complimentStart + randomModifier.getModifierValueFromEnum() + " " + superlative.getSuperlativeValueFromEnum();
        return compliment;
    }

    public void tagAFriendAndTweet(String twitterHandle) throws TwitterException {
        String compliment = generateCompliment();
        TwitterApp.createTweet(twitterHandle +" "+ compliment);
    }
}
