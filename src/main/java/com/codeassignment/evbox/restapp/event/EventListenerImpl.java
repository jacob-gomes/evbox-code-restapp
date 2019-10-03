package com.codeassignment.evbox.restapp.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventListenerImpl {

	@Async
	@EventListener
	public void listenToEvent(EventApplicationImpl eventApplicationImpl) {
		System.out.println(eventApplicationImpl.getMessage());
	}
}
