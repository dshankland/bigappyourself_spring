package com.codeclan.example.BigAppYourself;

import com.codeclan.example.BigAppYourself.twitter.TwitterApp;
import org.junit.Test;
import twitter4j.TwitterException;

import static org.junit.Assert.assertEquals;

public class TwitterTest {

    String tweet = "Your shoulder blades are amazing!";

    @Test
    public void givenText_updateStatus() throws TwitterException {
        String text = TwitterApp.createTweet(tweet);
        assertEquals(tweet, text);
    }

    @Test
    public void canSendDirectMessage() throws TwitterException{
        TwitterApp.sendDirectMessage("@hughdjarvis", "Tweet Tweet");
        TwitterApp.sendDirectMessage("@darrenshankland", "Tweet Tweet");
    }
}
