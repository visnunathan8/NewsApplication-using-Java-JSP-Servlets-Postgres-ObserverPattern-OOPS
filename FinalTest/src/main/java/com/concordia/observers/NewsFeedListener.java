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
	public void update(Integer publisherId, JSONObject review) {
		try {
			Review reviewData = Review.setAllReviewDataObject(review);
			Integer reviewId = ReviewRepository.insertToReviewTable(reviewData);
			ArrayList<Integer> subIds = NotifierRepository.getSubscriberIds(publisherId);
			SubscriberRepository.insertSubscriberData(subIds, reviewId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void addSubscriberToPublisher(Integer subscriberId, Integer publisherId) {
		try {
			NotifierRepository.insertSubscriberData(subscriberId, publisherId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeSubscriberToPublisher(Integer publisherId, Integer subscriberId) {
		try {
			NotifierRepository.deleteSubscriberData(publisherId, subscriberId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
