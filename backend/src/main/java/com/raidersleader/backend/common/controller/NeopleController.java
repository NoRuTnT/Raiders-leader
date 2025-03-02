package com.raidersleader.backend.common.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/neople")
@CrossOrigin(origins = "http://localhost:3000")
public class NeopleController {

	@Value("${neople.api.key}")
	private String API_KEY;

	@Value("${neople.api.url}")
	private String BASE_URL;


	@GetMapping("/character")
	public ResponseEntity<?> searchCharacters(
		@RequestParam String characterName) {

		String url = String.format("%s/servers/all/characters?characterName=%s&apikey=%s",
			BASE_URL, characterName, API_KEY);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	}

	@GetMapping("/character-info")
	public ResponseEntity<?> getCharacterInfo(
		@RequestParam String serverId,
		@RequestParam String characterId) {

		String url = String.format("%s/servers/%s/characters/%s?apikey=%s",
			BASE_URL, serverId, characterId, API_KEY);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	}


}
