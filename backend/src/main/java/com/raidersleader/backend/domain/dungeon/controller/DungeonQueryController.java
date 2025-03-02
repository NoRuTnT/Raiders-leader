package com.raidersleader.backend.domain.dungeon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raidersleader.backend.common.model.dto.SuccessResponse;
import com.raidersleader.backend.domain.dungeon.service.DungeonQueryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/dungeon")
@RestController
public class DungeonQueryController {
	private final DungeonQueryService dungeonQueryService;

	@GetMapping("")
	public ResponseEntity<SuccessResponse> dungeonList(){
		return ResponseEntity.ok(SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(dungeonQueryService.findAllDungeons())
				.build());
	}


}
