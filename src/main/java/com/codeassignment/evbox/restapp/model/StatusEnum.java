package com.codeassignment.evbox.restapp.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
	 
	IN_PROGRESS("IN_PROGRESS"),FINISHED("FINISHED");
	
	String status;
	
	StatusEnum(String status){
		this.status = status;
	}
	
	@JsonValue
	public String statusValue() {
		return this.status;
	}
}
