package com.codeclan.example.BigAppYourself;

import com.codeclan.example.BigAppYourself.repositories.UserRepository;
import com.codeclan.example.BigAppYourself.twitter.TwitterApp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.TwitterException;
import com.codeclan.example.BigAppYourself.models.Keyword;
import com.codeclan.example.BigAppYourself.models.User;

import static org.junit.Assert.assertEquals;

public class TwitterTest {

    @Autowired
    UserRepository userRepository;

    private User user;
    private User user2;
    private User user3;

    @Before
    public void setUp() throws Exception {
        user = new User("John", "Moir", "john@4bigappyourself.com", "password" );
        user2 = new User("Darren", "Shankland", "darren@bigappyourself.com", "password" );
        user3 = new User("Hugh", "Jarvis","hugh@bigappyourself.com", "password" );
    }

//    String tweet = "Your git merge is amazing!";
//
//    @Test
//    public void givenText_updateStatus() throws TwitterException {
//        String text = TwitterApp.createTweet(tweet);
//        assertEquals(tweet, text);
//    }

    @Test
    public void canSendDirectMessage() throws TwitterException{
        TwitterApp.sendDirectMessage("@hughdjarvis", "Tweet Tweet");
        TwitterApp.sendDirectMessage("@darrenshankland", "Tweet Tweet");
    }

    @Test
    public void canGenerateComplimentAndTweet() throws TwitterException{
        user.generateCompliment();
        String randomComp = "@CodeClanScot " + user.getCompliment();
        TwitterApp.createTweet(randomComp);
    }

    @Test
    public void canGenerateComplimentandDM() throws TwitterException{
        user2.setTwitter("@darrenshankland");
        user3.setTwitter("@hughdjarvis");
        user2.generateCompliment();
        user3.generateCompliment();
        TwitterApp.sendDirectMessage(user2.getTwitter(), user2.getCompliment());
        TwitterApp.sendDirectMessage(user3.getTwitter(), user3.getCompliment());
    }
}
