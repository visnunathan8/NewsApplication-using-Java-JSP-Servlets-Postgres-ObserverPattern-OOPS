package com.concordia.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.concordia.entity.MultiMedia;
import com.concordia.repository.MultimediaRepository;


class MultimediaRepositoryTest {
	MultiMedia multimedia = new MultiMedia("image", "http://static01.nyt.com/images/2015/10/07/topics/ao-scott/ao-scott-articleInline.jpg", 220, 163, "Earl Wilson/<br/>The New York Times");
	
	@Test
	void testInsertToMultimediaTable() {
		Integer value = MultimediaRepository.insertToMultimediaTable(multimedia);
		Assert.assertTrue(value instanceof Integer);
	}

	@Test
	void testSelectFromMultimedia() {
		MultiMedia actual = MultimediaRepository.selectFromMultimedia(2740);
		String expected = "image";
		assertEquals(actual.getType(), expected);
	}

}
