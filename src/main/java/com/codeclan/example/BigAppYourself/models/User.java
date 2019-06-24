package com.codeclan.example.BigAppYourself.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import com.codeclan.example.BigAppYourself.payloads.Email;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private LocalDate birthday;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String twitter;



//    @ElementCollection(targetClass = Skill.class)
//    @CollectionTable(name = "person_skill", joinColumns = @JoinColumn(name = "person_id"))
//    @Enumerated(EnumType.STRING)
//    @Column(name = "skill_id")


    @ElementCollection(targetClass = Keyword.class)
    @CollectionTable(name = "user_keywords", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "keyword_id")
    private List<Keyword> preferences;

    @Column
    private String compliment;

    @Column
//    @JsonIgnore
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
        this.compliment = "You are awesome! Thanks for registering!";
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
