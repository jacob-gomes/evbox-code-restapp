package com.codeassignment.evbox.restapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.codeassignment.evbox.restapp.exception.ResourceNotFoundException;
import com.codeassignment.evbox.restapp.model.SessionObject;
import com.codeassignment.evbox.restapp.model.StatusEnum;
import com.codeassignment.evbox.restapp.model.SummaryObject;

/**
 * 
 * @author Jacob
 *
 */
@Component
public class EVBoxServiceImpl implements EVBoxService {

	private Map<UUID,SessionObject> startedSessionTracker;
	
	private Map<UUID,SessionObject> stoppedSessionTracker;
	
	@PostConstruct 
	void initilize() {
		startedSessionTracker = new Hashtable<>();
		stoppedSessionTracker = new Hashtable<>();
	}
	
	@Override
	public void createSession(SessionObject sessionObject) {
		sessionObject.setId(UUID.randomUUID());
		sessionObject.setStartedAt(LocalDateTime.now());
		sessionObject.setStatus(StatusEnum.IN_PROGRESS);
		startedSessionTracker.put(sessionObject.getId(), sessionObject);
	}

	@Override
	public SessionObject stopSession(UUID id) {
		SessionObject sessionObject = startedSessionTracker.get(id);
		if(null == sessionObject) {
			throw new ResourceNotFoundException();
		}
		
		sessionObject.setStoppedAt(LocalDateTime.now());
		sessionObject.setStatus(StatusEnum.FINISHED);
		stoppedSessionTracker.put(id, sessionObject);
		startedSessionTracker.remove(id);
		return sessionObject;
	}

	@Override
	public List<SessionObject> retrieveSessions() {
		List<SessionObject> sessionObjectlist = new ArrayList<SessionObject>();
		sessionObjectlist.addAll(startedSessionTracker.values());
		sessionObjectlist.addAll(stoppedSessionTracker.values());
		
		return sessionObjectlist;
	}

	@Override
	public SummaryObject summarizeSessions() {
		SummaryObject summaryObject = new SummaryObject();
		LocalDateTime oneMinuteBeforeTime = LocalDateTime.now().minusMinutes(1); 
		
		summaryObject.setStartedCount(0);
		summaryObject.setStoppedCount(0);
		//Integer startedSessionCount = startedSessionTracker.size();
		//Integer stoppedSessionCount = stoppedSessionTracker.size();
		
		startedSessionTracker.forEach((key,object) ->{
			SessionObject sessionObject = (SessionObject)object;
			if(sessionObject.getStartedAt().isAfter(oneMinuteBeforeTime)) { 
				summaryObject.setStartedCount(summaryObject.getStartedCount()+1);
			}
		});
		stoppedSessionTracker.forEach((key,object) ->{
			SessionObject sessionObject = (SessionObject)object;
			if(sessionObject.getStartedAt().isAfter(oneMinuteBeforeTime)) {
				summaryObject.setStoppedCount(summaryObject.getStoppedCount()+1);
			}
		});
		
		//summaryObject.setStartedCount(startedSessionCount);
		//summaryObject.setStoppedCount(stoppedSessionCount);
		summaryObject.setTotalCount(summaryObject.getStoppedCount() + summaryObject.getStartedCount());
		
		return summaryObject;
	}

}
