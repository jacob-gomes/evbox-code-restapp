package com.codeassignment.evbox.restapp.service;

import java.util.List;
import java.util.UUID;

import com.codeassignment.evbox.restapp.model.SessionObject;
import com.codeassignment.evbox.restapp.model.SummaryObject;

public interface EVBoxService {

	void createSession(SessionObject sessionObject);

	SessionObject stopSession(UUID id);

	List<SessionObject> retrieveSessions();

	SummaryObject summarizeSessions();

}
