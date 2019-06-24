package com.codeclan.example.BigAppYourself;

import com.codeclan.example.BigAppYourself.Email.SendGridEmailService;
import com.codeclan.example.BigAppYourself.SMS.SmsSender;
import com.codeclan.example.BigAppYourself.components.ComplimentDispatcher;
import com.codeclan.example.BigAppYourself.models.Keyword;
import com.codeclan.example.BigAppYourself.models.User;
import com.codeclan.example.BigAppYourself.repositories.UserRepository;
import com.codeclan.example.BigAppYourself.payloads.Email;
import com.codeclan.example.BigAppYourself.twitter.TwitterApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import twitter4j.TwitterException;


import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigAppYourselfApplicationTests {

	@Autowired
	SmsSender smsSender;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ComplimentDispatcher complimentDispatcher;

  @Autowired
	SendGridEmailService sendGridEmailService;

	private LocalDate user1Birthday;
	private LocalDate user2Birthday;
	private LocalDate user3Birthday;
	private User darren;
	private User user2;
	private User user3;
	private TwitterApp twitterApp;




	@Before
	public void setUp() throws Exception {
//		user1Birthday = LocalDate.of(1972, 12, 25);
//		user2Birthday = LocalDate.of(1974, 12, 25);
//		user3Birthday = LocalDate.of(1982, 12, 25);


		darren = new User("Darren", "Shankland", "jmmoir@outlook.com", "password" );
user2 = new User("Hugh", "Jarvis","hugh.jarvis@blueyonder.co.uk", "password" );
//		user3 = new User("John", "Moir", "john@4bigappyourself.com", "password" );
//
//		user1.addPreference(Keyword.CODING);
//		user1.addPreference(Keyword.FACE);
//
user2.addPreference(Keyword.HAIR);
user2.addPreference(Keyword.CHARM);
//
//		user3.addPreference(Keyword.KNOWLEDGE);
//		user3.addPreference(Keyword.STARTUP);

	}

//	@Test
//	public void userHasName() {
//		assertEquals("Hugh", user2.getFirstName());
//	}
//
//	@Test
//	public void canSetCompliment() {
//		user1.generateCompliment();
//		user2.generateCompliment();
//		user3.generateCompliment();
//		System.out.println(user1.getCompliment());
//		System.out.println(user2.getCompliment());
//		System.out.println(user3.getCompliment());
//		assertNotEquals("", user1.getCompliment());
//		assertNotEquals("", user2.getCompliment());
//		assertNotEquals("", user3.getCompliment());
//	}


	@Test
	public void canAddUser() {
		darren = new User("Darren", "Shankland", "darren@bigappyourself.com", "password" );
		darren.addPreference(Keyword.CODING);
		darren.addPreference(Keyword.DATABASE);
		darren.generateCompliment();
		userRepository.save(darren);
		darren.addPreference(Keyword.COOKING);
	}

	@Test
	public void canSendEmail(){

		Email email = new Email();
		email.setRecipient(System.getenv("HUGH_EMAIL_ADDRESS"));
		email.setRecipientFirstName("Hugh");
		email.setRecipientLastName("Jarvis");
		email.setReplyTo("bigappyourself@gmail.com");
		email.setSubject("Fresh compliment for ");
		email.setHtmlBody("<h1> Your start-up is valued at £4billion</h1>");
		sendGridEmailService.send(email);
	}

	@Test
	public void canCreateComplimentEmail(){
		assertEquals("Hugh", user2.generateComplimentEmail().getRecipientFirstName());
	}

	@Test
	public void canEmailComplimentToUser(){
		user2.setCompliment("You are a wonderful human being");
		user2.sendComplimentEmail();
	}

	@Test
	public void canGetAllUsers() {
		complimentDispatcher.getAllUsers();
		assertEquals(3, complimentDispatcher.getUsers().size());
	}

	@Test
	public void canComplimentAllUsers() throws TwitterException {
			complimentDispatcher.sendCompliments();
	}

	@Test
	public void canSendSMS() {
		user2.setPhone("+447813684853");
		user2.generateCompliment();
		smsSender.sendSMS(user2);
	}
}


