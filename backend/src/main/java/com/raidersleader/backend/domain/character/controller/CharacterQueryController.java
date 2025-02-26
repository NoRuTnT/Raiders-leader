package com.raidersleader.backend.domain.character.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raidersleader.backend.common.model.dto.SuccessResponse;
import com.raidersleader.backend.domain.character.service.CharacterQueryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/character")
public class CharacterQueryController {
	private final CharacterQueryService characterQueryService;

	@GetMapping("/adventure")
	public ResponseEntity<SuccessResponse> adventureCharacterList(@RequestParam("AdventureName") String AdventureName){
		return ResponseEntity.ok(SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(characterQueryService.findAdventureCharacterList(AdventureName))
				.build());
	}


	@GetMapping
	public ResponseEntity<SuccessResponse> characterDetail(@RequestParam("characterName") String characterName){

		return ResponseEntity.ok(
			SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(characterQueryService.findCharacterDetailByName(characterName))
				.build());
	}


}
