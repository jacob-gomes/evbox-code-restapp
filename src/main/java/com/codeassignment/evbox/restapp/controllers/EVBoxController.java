package com.codeassignment.evbox.restapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeassignment.evbox.restapp.model.SessionObject;
import com.codeassignment.evbox.restapp.model.SummaryObject;
import com.codeassignment.evbox.restapp.service.EVBoxService;

/**
 * 
 * @author Jacob
 *
 */
@RestController
public class EVBoxController {
	
	@Autowired
	private EVBoxService evBoxService;
	
	@PostMapping(value = "/chargingSessions",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<SessionObject> createSession(			
			SessionObject sessionObject) {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		evBoxService.createSession(sessionObject);
		
		return new ResponseEntity<>(sessionObject, httpHeader, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/chargingSessions/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SessionObject> stopSession(			
			@PathVariable("id") UUID id) {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		SessionObject sessionObject = evBoxService.stopSession(id);
		
		return new ResponseEntity<>(sessionObject, httpHeader, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/chargingSessions",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SessionObject>> retrieveSessions() {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		List<SessionObject> sessionObjectArray = evBoxService.retrieveSessions();
		
		return new ResponseEntity<>(sessionObjectArray, httpHeader, HttpStatus.OK);
	}
	
	@GetMapping(value = "/chargingSessions/summary",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SummaryObject> summarizeSessions() {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		SummaryObject summaryObject = evBoxService.summarizeSessions();
		
		return new ResponseEntity<>(summaryObject, httpHeader, HttpStatus.OK);
	}
	
}
