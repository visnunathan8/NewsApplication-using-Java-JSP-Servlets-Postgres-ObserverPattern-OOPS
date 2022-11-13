package com.concordia.entity;

import java.util.ArrayList;
import com.concordia.interfaces.Subject;
import com.concordia.observers.NewsFeedListener;
import com.concordia.repository.NotifierRepository;

public class Notifier implements Subject{
	
	Integer publisher;
	ArrayList<Integer> subscribers;
	NewsFeedListener observer = new NewsFeedListener();
	
	public Notifier(int publisher) {
		subscribers = NotifierRepository.getSubscriberIds(publisher);
	}

	public Integer getPublisher() {
		return publisher;
	}

	public void setPublisher(Integer publisher) {
		this.publisher = publisher;
	}

	public ArrayList<Integer> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(ArrayList<Integer> subscribers) {
		this.subscribers = subscribers;
	}

	public NewsFeedListener getObserver() {
		return observer;
	}

	public void setObserver(NewsFeedListener observer) {
		this.observer = observer;
	}
	
	@Override
	public void notifyObservers(Integer publisherId, Review review) {
		for (int i = 0; i < subscribers.size(); i++) {
			observer.update(publisherId, review);
		}
	}

	@Override
	public void addObserver(Integer subscriberId, Integer publisherId) {
		subscribers.add(publisherId);
		observer.addSubscriberToPublisher(subscriberId, publisherId);
	}

	@Override
	public void removeObserver(Integer subscriberId) {
		subscribers.remove(subscriberId);
		observer.removeSubscriberToPublisher(subscriberId);
	}
	
	
}
