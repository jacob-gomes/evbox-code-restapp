package com.codeassignment.evbox.restapp.controllers.exceptionadvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codeassignment.evbox.restapp.exception.ResourceNotFoundException;
import com.codeassignment.evbox.restapp.model.ErrorResponse;

@ControllerAdvice
public class EXBoxControllerExceptionAdvice {

	//@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
	public ErrorResponse handleException(Exception exception) {
		return new ErrorResponse("500", "Error Found");
	}
	
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
	public ErrorResponse handleResourceNotFoundExceptionException(ResourceNotFoundException exception) {
		return new ErrorResponse("404","Resource Not Found");
	}
}
