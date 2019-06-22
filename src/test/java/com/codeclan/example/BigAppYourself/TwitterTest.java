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

    @Before
    public void setUp() throws Exception {
        user = new User("John", "Moir", "john@4bigappyourself.com", "password" );
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
        String randomComp = user.getCompliment();
        TwitterApp.createTweet(randomComp);
    }


}
