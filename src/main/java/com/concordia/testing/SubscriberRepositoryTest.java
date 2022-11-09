package com.concordia.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.concordia.repository.SubscriberRepository;

class SubscriberRepositoryTest {

	@Test
	void testInsertSubscriberData() {
		Integer value = SubscriberRepository.insertSubscriberData(1732, 1);
		Assert.assertTrue(value instanceof Integer);
	}

	@Test
	void testGetReviewId() {
		Integer expected = Integer.valueOf("1746");
		ArrayList<Integer> actual = SubscriberRepository.getReviewId(1);
		assertEquals(expected, actual.get(0));
	}

}
