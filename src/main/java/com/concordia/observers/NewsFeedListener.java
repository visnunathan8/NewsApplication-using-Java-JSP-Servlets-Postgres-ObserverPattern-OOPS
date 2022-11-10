package com.concordia.observers;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.concordia.entity.Notifier;
import com.concordia.entity.Review;
import com.concordia.interfaces.Observer;
import com.concordia.repository.NotifierRepository;
import com.concordia.repository.ReviewRepository;
import com.concordia.repository.SubscriberRepository;

public class NewsFeedListener implements Observer{
	
	@Override
	public void update(Integer publisherId, Review review) {
		try {
			Integer reviewId = ReviewRepository.insertToReviewTable(review);
			SubscriberRepository.insertSubscriberData(publisherId, reviewId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addSubscriberToPublisher(Integer subscriberId, Integer publisherId) {
		try {
			NotifierRepository.insertSubscriberData(subscriberId, publisherId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeSubscriberToPublisher(Integer subscriberId) {
		try {
			NotifierRepository.deletePublisherData(subscriberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
