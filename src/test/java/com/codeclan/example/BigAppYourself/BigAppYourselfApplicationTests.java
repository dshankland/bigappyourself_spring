package com.codeclan.example.BigAppYourself;

import com.codeclan.example.BigAppYourself.models.Keyword;
import com.codeclan.example.BigAppYourself.models.Keyword_old;
import com.codeclan.example.BigAppYourself.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigAppYourselfApplicationTests {

	private LocalDate user1Birthday;
	private LocalDate user2Birthday;
	private LocalDate user3Birthday;
	private User user1;
	private User user2;
	private User user3;


	@Before
	public void setUp() throws Exception {
//		user1Birthday = LocalDate.of(1972, 12, 25);
//		user2Birthday = LocalDate.of(1974, 12, 25);
//		user3Birthday = LocalDate.of(1982, 12, 25);


		user1 = new User("Darren", "Shankland", "darren@bigappyourself.com", "password" );
		user2 = new User("Hugh", "Jarvis","hugh@bigappyourself.com", "password" );
		user3 = new User("John", "Moir", "john@4bigappyourself.com", "password" );

		user1.addPreference(Keyword.CODING);
		user1.addPreference(Keyword.FACE);

		user2.addPreference(Keyword.HAIR);
		user2.addPreference(Keyword.CHARM);

		user3.addPreference(Keyword.KNOWLEDGE);
		user3.addPreference(Keyword.STARTUP);

	}

	@Test
	public void userHasName() {
		assertEquals("Hugh", user2.getFirstName());
	}

	@Test
	public void canSetCompliment() {
		user1.generateCompliment();
		user2.generateCompliment();
		user3.generateCompliment();
		System.out.println(user1.getCompliment());
		System.out.println(user2.getCompliment());
		System.out.println(user3.getCompliment());
		assertNotEquals("", user1.getCompliment());
		assertNotEquals("", user2.getCompliment());
		assertNotEquals("", user3.getCompliment());
	}
}
