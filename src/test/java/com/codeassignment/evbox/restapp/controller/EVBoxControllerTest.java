package com.codeassignment.evbox.restapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.codeassignment.evbox.restapp.controllers.EVBoxController;
import com.codeassignment.evbox.restapp.service.EVBoxServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EVBoxController.class, EVBoxServiceImpl.class})
@WebAppConfiguration
@WebMvcTest(value = EVBoxController.class)
public class EVBoxControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private String id;
	
	@Test
	public void createNewSession() throws Exception {
		String requestPayload = "{\"stationId\":\"ABC-12345\"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/chargingSessions").accept(MediaType.APPLICATION_JSON)
				.content(requestPayload.getBytes())
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
		
		String responseString = new String (result.getResponse().getContentAsByteArray());
	
		JSONObject responseObject = new JSONObject(responseString);
		
		id = responseObject.getString("id");
		assertNotNull(id);
	}
	
	@Test
	public void deleteNewSession() throws Exception {
		createNewSession();
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/chargingSessions/"+id).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		
		String responseString = new String (result.getResponse().getContentAsByteArray());
		
		JSONObject responseObject = new JSONObject(responseString);
		String stoppedAt = responseObject.optString("stoppedAt");
		
		assertNotNull(stoppedAt);
	}
	
	@Test
	public void retreiveAllSession() throws Exception {
		createNewSession();
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/chargingSessions/").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		
		String responseString = new String (result.getResponse().getContentAsByteArray());
		
		JSONArray responseObject = new JSONArray(responseString);
		int arrayLength = responseObject.length();
		assertNotEquals(arrayLength,0);
	}
	
	@Test
	public void retreiveSummary() throws Exception{
		createNewSession();
		deleteNewSession();
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/chargingSessions/summary").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		
		String responseString = new String (result.getResponse().getContentAsByteArray());
		JSONObject responseObject = new JSONObject(responseString);
		
		int totalCount = responseObject.optInt("totalCount");
		int startedCount = responseObject.optInt("startedCount");
		int stoppedCount = responseObject.optInt("stoppedCount");
		
		assertNotEquals(totalCount,0);
		assertNotEquals(startedCount,0);
		assertNotEquals(stoppedCount,0);
		
	}
}
