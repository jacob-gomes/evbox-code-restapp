package com.codeassignment.evbox.restapp.event;

import org.springframework.context.ApplicationEvent;

public class EventApplicationImpl extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	public EventApplicationImpl(Object source, String message) {
		super(source);
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		 this.message = message;
	}
}
