package com.concordia.interfaces;

import org.json.simple.JSONObject;

public interface Observer {
	public void update(Integer publisherId, JSONObject review);
	public void addSubscriberToPublisher(Integer publisherId, Integer subscriberId);
	public void removeSubscriberToPublisher(Integer publisherId, Integer subscriberId);
}
