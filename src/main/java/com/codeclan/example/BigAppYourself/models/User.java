package com.codeclan.example.BigAppYourself.models;

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
    private String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = null;
        this.phone = null;
        this.email = email;
        this.twitter = null;
        this.preferences = new ArrayList<>();
        this.preferences.add(Keyword.GENERAL);
        this.compliment = "";
        this.password = password;
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

    public void setPreferences(List<Keyword> preferences) {
        this.preferences = preferences;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void generateCompliment() {
        Random random=new Random();
        int randomNumber=random.nextInt(this.preferences.size());
        Keyword randomKeyword = this.preferences.get(randomNumber);
        Superlative superlative = Superlative.getRandom();
        String complimentStart = "Your " + randomKeyword.name().toLowerCase() + " " + randomKeyword.getkeywordTextFragFromEnum() + " ";
        if (randomKeyword == Keyword.GENERAL) {
            complimentStart = "You are ";
        }
        String compliment = complimentStart + superlative.getSuperlativeValueFromEnum();
        this.setCompliment(compliment);
    }
}
