package com.codeassignment.evbox.restapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Jacob
 *
 */
@JsonInclude(Include.NON_NULL)
public class SummaryObject {

	Integer totalCount;
	
	Integer startedCount;
	
	Integer stoppedCount;

	/**
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the startedCount
	 */
	public Integer getStartedCount() {
		return startedCount;
	}

	/**
	 * @param startedCount the startedCount to set
	 */
	public void setStartedCount(Integer startedCount) {
		this.startedCount = startedCount;
	}

	/**
	 * @return the stoppedCount
	 */
	public Integer getStoppedCount() {
		return stoppedCount;
	}

	/**
	 * @param stoppedCount the stoppedCount to set
	 */
	public void setStoppedCount(Integer stoppedCount) {
		this.stoppedCount = stoppedCount;
	}
	
	
}
