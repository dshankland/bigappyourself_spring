package com.codeclan.example.BigAppYourself.models;

import com.codeclan.example.BigAppYourself.payloads.Email;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.time.LocalDate;
import java.util.*;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String phone;
    private String email;
    private String twitter;
    private List<Keyword> preferences;
    private String compliment;

    public User(String firstName, String lastName, LocalDate birthday, String phone, String email, String twitter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.twitter = twitter;
        this.preferences = new ArrayList<>();
        Keyword generalKeyword = new Keyword("general", "");
        this.preferences.add(generalKeyword);
        this.compliment = "";
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public List<Keyword> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Keyword> prefereences) {
        this.preferences = prefereences;
    }

    public void addPreference(Keyword preference) {
        this.preferences.add(preference);
    }

    public String getCompliment() {
        return compliment;
    }

    public void setCompliment(String compliment) {
        this.compliment = compliment;
    }

    public void generateCompliment() {
        Random random=new Random();
        int randomNumber=random.nextInt(this.preferences.size());
        Keyword randomKeyword = this.preferences.get(randomNumber);
        Superlative superlative = Superlative.getRandom();
        String complimentStart = "Your " + randomKeyword.getName() + " " + randomKeyword.getTextfrag() + " ";
        if (randomKeyword.getName().equals("general")) {
            complimentStart = "You are ";
        }
        String compliment = complimentStart + superlative.getSuperlativeValueFromEnum();
        this.setCompliment(compliment);
    }

    public Email generateComplimentEmail(){
        Email complimentEmail = new Email();
        complimentEmail.setRecipient(this.getEmail());
        complimentEmail.setRecipientFirstName(this.getFirstName());
        complimentEmail.setRecipientLastName(this.getLastName());
        complimentEmail.setReplyTo("bigappyourself@gmail.com");
        complimentEmail.setSubject("Fresh compliment for " + this.getFirstName());
        complimentEmail.setTextBody("Hi " + this.getFirstName() + ", " + this.getCompliment());
        return complimentEmail;
    }

    public Message generateComplimentMessage(){
        PhoneNumber phoneNumberTo = new PhoneNumber(this.getPhone());
        PhoneNumber phoneNumberFrom = new PhoneNumber("+441253530348");
        Message complimentSMS = Message.creator(phoneNumberTo, phoneNumberFrom, this.getCompliment()).create();
        return complimentSMS;
        }
}
