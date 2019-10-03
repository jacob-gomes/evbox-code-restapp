package com.codeassignment.evbox.restapp.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventDoer {
	
	@Autowired
	private EventPublisher eventPublisher;
	
	@Test
	public void initateEvent() throws InterruptedException {
		
		EventApplicationImpl eventApplicationImpl = eventPublisher.doStuffToPublishEvent("Hello");		
		//Thread.sleep(10000L);
		eventApplicationImpl.setMessage("Good bye");// does not initiate trigger of event
		eventPublisher.doStuffToPublishEvent("Good bye");
	}
}
