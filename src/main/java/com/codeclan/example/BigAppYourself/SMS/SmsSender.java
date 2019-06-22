package com.codeclan.example.BigAppYourself.SMS;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SmsSender {

    public static final String ACCOUNT_SID = "AC934c54990a52597e0980a242b7bcdd4a";
    public static final String AUTH_TOKEN = "y9dac0ab9c1a4b05ccffa22b4fd5812fd";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+441253530348"),
                new PhoneNumber("+447813684853"),
                "Your coding skills are no bad").create();

       // System.out.println(message.getSid());

    }
}