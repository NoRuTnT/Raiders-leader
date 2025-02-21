package com.raidersleader.backend.domain.character.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raidersleader.backend.common.model.dto.SuccessResponse;
import com.raidersleader.backend.domain.character.model.entity.Character;
import com.raidersleader.backend.domain.character.service.CharacterCommandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/character")
public class CharacterCommandController {
	private final CharacterCommandService characterCommandService;

	@PostMapping("")
	public ResponseEntity<SuccessResponse> characterAdd(@RequestBody Character character){
		if (character.getCharacterId() == null || character.getCharacterId().isBlank()) {
			return ResponseEntity.badRequest()
				.body(SuccessResponse.builder()
					.status(HttpStatus.BAD_REQUEST)
					.message("캐릭터ID는 필수입니다.")
					.build());
		}

		characterCommandService.addCharacter(character);
		return ResponseEntity.ok(
			SuccessResponse.builder()
				.status(HttpStatus.OK)
				.message("캐릭터 등록에 성공했습니다.")
				.result(character)
				.build());

	}

	@PutMapping("/{characterId}")
	public ResponseEntity<SuccessResponse> characterUpdate(@PathVariable String characterId, @RequestBody Character character){
		characterCommandService.updateCharacter(characterId, character);
		return ResponseEntity.ok(
			SuccessResponse.builder()
			.status(HttpStatus.OK)
			.message("캐릭터 정보 수정에 성공했습니다.")
			.result(character)
			.build());


	}
}
