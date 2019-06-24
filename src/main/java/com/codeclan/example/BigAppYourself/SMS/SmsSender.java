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

    public String ACCOUNT_SID = "AC934c54990a52597e0980a242b7bcdd4a";
    public String AUTH_TOKEN = "y9dac0ab9c1a4b05ccffa22b4fd5812fd";

    public void sendSMS(User user) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+441253530348"),
                new PhoneNumber(user.getPhone()),
                user.getCompliment())
                .create();

       // System.out.println(message.getSid());

    }
}