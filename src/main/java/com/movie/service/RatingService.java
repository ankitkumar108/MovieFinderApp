package com.movie.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	String apiUrl = "https://www.omdbapi.com/?i=tt3896198&apikey=19bbe7b4&t=";

	public String getImdbRating(String title) {
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<ObjectNode> responseEntity = restTemplate.getForEntity(apiUrl+title, ObjectNode.class);
			
			ObjectNode jsonObject = responseEntity.getBody();
			
			return jsonObject.path("imdbRating").asText();
		} catch (Exception e) {
			System.out.println("Either movie name wrong/unavailable or API is down" + e.getMessage());
		}
		return null;
	}
}