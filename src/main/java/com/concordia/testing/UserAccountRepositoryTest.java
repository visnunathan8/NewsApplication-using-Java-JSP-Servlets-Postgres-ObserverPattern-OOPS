package com.concordia.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.concordia.entity.UserAccount;
import com.concordia.repository.UserAccountRepository;

public class UserAccountRepositoryTest { 
	
	UserAccount user = new UserAccount("reviewer1", "reviewer1", "reviewer1@reviewer1.com", "12332123", "A");
	UserAccount newUser = new UserAccount("userTest", "userTest", "userTest@userTest.com", "1233222", "U");
	UserAccountRepository userRepo= new UserAccountRepository();
	
	@Test
	public void testGetUserId() {
		String expected = "31";
		String actual = userRepo.getUserId(user);
		System.out.println(actual);
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
		UserAccount user1 = new UserAccount("reviewer1", null, "reviewer1@reviewer1.com",null, null);
		user1.setUserId(31);
		expected.add(user1);
		ArrayList<UserAccount> actual = userRepo.getPublishers();
		Assert.assertEquals(expected.get(0).getUserId(),actual.get(0).getUserId());
	}

}
