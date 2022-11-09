package com.concordia.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.concordia.entity.MovieLink;
import com.concordia.entity.MultiMedia;
import com.concordia.entity.Review;
import com.concordia.repository.ReviewRepository;



class ReviewRepositoryTest {
	Review review = new Review(1746,"example", "A", 1, "example", "example", "example", "example", "example", "example");
	Review review1 = new Review(2746,"example1", "A", 1, "example1", "example1", "example1", "example1", "example1", "example1");

	@Test
	void testInsertToReviewTable() {
		Integer expected = 1746;
		Integer actual = ReviewRepository.insertToReviewTable(review);
		assertEquals(expected, actual);
	}

	@Test
	void testSelectFromReviewTable() {
		ArrayList<Review> expected = ReviewRepository.selectFromReviewTable();
		String actual = "Weird: The Al Yankovic Story";
		assertEquals(expected.get(0).getDisplay_title(), actual);
	}

	@Test
	void testSelectAReview() {
		Review expected = ReviewRepository.selectAReview(1721);
		String actual = "What We Leave Behind";
		assertEquals(expected.getDisplay_title(), actual);
	}

}
