package com.concordia.interfaces;

import com.concordia.entity.Review;

public interface Observer {
	public void update(Integer publisherId, Review review);
	public void addSubscriberToPublisher(Integer publisherId, Integer subscriberId);
	public void removeSubscriberToPublisher(Integer subscriberId);
}
