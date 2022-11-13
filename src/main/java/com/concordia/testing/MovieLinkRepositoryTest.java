package com.concordia.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.concordia.entity.MovieLink;
import com.concordia.repository.MovieLinkRepository;


class MovieLinkRepositoryTest {
	
	MovieLink movielink = new MovieLink("article1","https://www.nytimes.com/2022/11/03/movies/weird-the-al-yankovic-story-review.html", "Read the New York Times Review of Weird: The Al Yankovic Story" );
	
	@Test
	void testInsertToMovieLinkTable() {
		Integer value = MovieLinkRepository.insertToMovieLinkTable(movielink);
		Assert.assertTrue(value instanceof Integer);
	}

	@Test
	void testSelectFromMovieLink() {
		MovieLink actual = MovieLinkRepository.selectFromMovieLink(1645);
		assertEquals(actual.getURL(), movielink.getURL());
	}

}
