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
    public String ACCOUNT_SID = "*****************";
    public String AUTH_TOKEN = "******************";
    public void sendSMS(User user) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(user.getPhone()),
                new PhoneNumber("+441253530348"),
                "Hi " + user.getFirstName() + ", " + user.getCompliment())
                .create();
       // System.out.println(message.getSid());
    }
}