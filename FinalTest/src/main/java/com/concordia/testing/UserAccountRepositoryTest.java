package com.concordia.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.concordia.entity.UserAccount;
import com.concordia.repository.UserAccountRepository;

public class UserAccountRepositoryTest {
	UserAccount user = new UserAccount("admin", "admin", "admin@admin.com", "123", "A");
	UserAccount newUser = new UserAccount("userTest", "userTest", "userTest@userTest.com", "1233222", "U");
	UserAccountRepository userRepo= new UserAccountRepository();
	@Test
	public void testGetUserId() {
		String expected = "1";
		String actual = userRepo.getUserId(user);
		assertEquals(expected, actual);
	}

	@Test
	public void testValidate() {
		Boolean expected = true;
		Boolean actual = userRepo.validate(user);
		assertEquals(expected, actual);
	}

	@Test
	public void testInsertToDatabase() {
		Boolean expected = true;
		Boolean actual = userRepo.insertToDatabase(newUser);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPublishers() {
		ArrayList<UserAccount> expected = new ArrayList<UserAccount>();
		UserAccount user1 = new UserAccount("admin", null, "admin@admin.com",null, null);
		user1.setUserId(1);
		expected.add(user1);
		ArrayList<UserAccount> actual = userRepo.getPublishers();
		Assert.assertEquals(expected.get(0).getUserId(),actual.get(0).getUserId());
	}

}
