package com.codeclan.example.BigAppYourself.SMS;

import com.codeclan.example.BigAppYourself.models.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class SmsSender {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public void sendSMS(String compliment, String number)  {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+441253530348"),
                new PhoneNumber(number), compliment).create();

       // System.out.println(message.getSid());

    }
}