package com.codeassignment.evbox.restapp.model;

public class ErrorResponse {
	
	String errorCode;
	
	String errorMessage;
	
	public ErrorResponse(String errorCode, String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorResponse
	 */
	public String getErrorResponse() {
		return errorMessage;
	}

	/**
	 * @param errorResponse the errorResponse to set
	 */
	public void setErrorResponse(String errorResponse) {
		this.errorMessage = errorResponse;
	}
	
}
