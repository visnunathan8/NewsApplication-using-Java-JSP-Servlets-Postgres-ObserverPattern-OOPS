package com.concordia.interfaces;

import org.json.simple.JSONObject;

import com.concordia.entity.Review;
import com.concordia.entity.UserAccount;

public interface Subject {
	public void addObserver (Integer publisherId, Integer subscriberId); 
	public void removeObserver (Integer subscriberId); 
	void notifyObservers(Integer publisher, Review review);
}
