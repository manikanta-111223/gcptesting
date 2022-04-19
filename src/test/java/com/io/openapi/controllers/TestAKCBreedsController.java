package com.io.openapi.controllers;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestAKCBreedsController.class)
public class TestAKCBreedsController {
	
	@Test
    void getBreedSuccessTest() throws Exception
	{
		HttpGet request = new HttpGet("http://localhost:8080/api/breeds?group=herding&origin_country=origin-countryValue");
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {

			assertTrue(response.getStatusLine().getStatusCode() == 200);
		}
    }
    
    
	@Test
    void getBreedFailureTest() throws Exception 
	{		
		HttpGet request = new HttpGet("http://localhost:8080/api/breeds?group=herding&origin_country=origin-countryValue");
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {

			assertFalse(response.getStatusLine().getStatusCode() != 404);
		}
    }
}
