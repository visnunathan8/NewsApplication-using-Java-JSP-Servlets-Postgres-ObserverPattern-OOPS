package com.concordia.interfaces;

import com.concordia.entity.Review;

public interface Subject {
	public void addObserver (Integer publisherId, Integer subscriberId); 
	public void removeObserver (Integer subscriberId); 
	void notifyObservers(Integer publisher, Review review);
}
