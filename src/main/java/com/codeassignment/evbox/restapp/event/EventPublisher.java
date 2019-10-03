package com.codeassignment.evbox.restapp.event;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@PostConstruct
	public void init() {
		System.out.println("Initializing");
	}
	
	public EventApplicationImpl doStuffToPublishEvent(String message) {
		System.out.println("Publishing custom event");
		EventApplicationImpl eventApplicationImpl = new EventApplicationImpl(this,message);
		applicationEventPublisher.publishEvent(eventApplicationImpl);
		return eventApplicationImpl;
	}
}
