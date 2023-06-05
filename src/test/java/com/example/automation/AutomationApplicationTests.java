package com.example.automation;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import com.example.automation.Models.Selenium;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;






@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AutomationApplicationTests {


	@LocalServerPort
	private int port;
	private String baseURL;
	
	@Test
	public void testCreate(){

		Selenium s = new Selenium();
        s.setFeature("Test Feature");
        s.setScenario("Test Scenario");
        s.setGiven("Test Given");
        s.setWhenStatement("Test When");
        s.setThenStatement("Test Then");

		baseURL = "http://localhost:" + port;

		TestRestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<String> response = restTemplate.postForEntity(baseURL, s,  String.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	public void testGetAll() {
		baseURL = "http://localhost:" + port + "/admin";

		TestRestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(baseURL, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}


	@Test
	public void testDelete() throws JsonMappingException, JsonProcessingException{

		Selenium s = new Selenium();
        s.setFeature("Test Feature");
        s.setScenario("Test Scenario");
        s.setGiven("Test Given");
        s.setWhenStatement("Test When");
        s.setThenStatement("Test Then");

		baseURL = "http://localhost:" + port;

		TestRestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<String> response = restTemplate.postForEntity(baseURL, s,  String.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		

		// Get an Object Mapper, to deserialize the response into a Selenium object, then we can use the getId to the object.
		ObjectMapper objectMapper = new ObjectMapper();
		Selenium createdSelenium = objectMapper.readValue(response.getBody(), Selenium.class);
		Long sId = createdSelenium.getId();
		

		ResponseEntity<?> deleteResponse = restTemplate.exchange(baseURL + "/delete/" + sId, HttpMethod.DELETE, null, Void.class);

		assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());

	}
}
