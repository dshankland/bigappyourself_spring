package com.codeclan.example.BigAppYourself;

import com.codeclan.example.BigAppYourself.models.Keyword;
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
public class BigAppYourselfTwitterAppTests {

	private LocalDate user1Birthday;
	private LocalDate user2Birthday;
	private LocalDate user3Birthday;
	private User user1;
	private User user2;
	private User user3;
	private Keyword keyword1;
	private Keyword keyword2;
	private Keyword keyword3;
	private Keyword keyword4;
	private Keyword keyword5;

	@Before
	public void setUp() throws Exception {
		user1Birthday = LocalDate.of(1972, 12, 25);
		user2Birthday = LocalDate.of(1974, 12, 25);
		user3Birthday = LocalDate.of(1982, 12, 25);

		keyword1 = new Keyword("beard", "is");
		keyword2 = new Keyword("hair", "is");
		keyword3 = new Keyword("face","is");
		keyword4 = new Keyword("brains", "are");

		user1 = new User("Darren", "Shankland", user1Birthday, "07999999999", "darren@bigappyourself.com", "dshankland" );
		user2 = new User("Hugh", "Jarvis", user2Birthday, "07777777777", "hugh@bigappyourself.com", "hughjarvis" );
		user3 = new User("John", "Moir", user3Birthday, "07666666666", "john@4bigappyourself.com", "johnmoir" );

		user1.addPreference(keyword1);
		user1.addPreference(keyword2);
		user1.addPreference(keyword3);
		user1.addPreference(keyword4);

		user2.addPreference(keyword1);
		user2.addPreference(keyword2);
		user2.addPreference(keyword3);
		user2.addPreference(keyword4);

		user3.addPreference(keyword1);
		user3.addPreference(keyword2);
		user3.addPreference(keyword3);
		user3.addPreference(keyword4);
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
