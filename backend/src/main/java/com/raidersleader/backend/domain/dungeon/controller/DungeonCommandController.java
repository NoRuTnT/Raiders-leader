package com.raidersleader.backend.domain.dungeon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raidersleader.backend.common.model.dto.SuccessResponse;
import com.raidersleader.backend.domain.dungeon.entity.Dungeon;
import com.raidersleader.backend.domain.dungeon.service.DungeonCommandService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/dungeon")
@RestController
public class DungeonCommandController {
	private final DungeonCommandService dungeonCommandService;

	@PostMapping
	public ResponseEntity<?> dungeonAdd(@RequestBody Dungeon dungeon, HttpServletRequest httprequest){

		Dungeon result = dungeonCommandService.addDungeon(dungeon);
		return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK,"던전 추가 성공",result));
	}

	@PutMapping(value = "/{dungeonId}")
	public ResponseEntity<?> dungeonUpdate(@PathVariable("dungeonId") Long dungeonId, @RequestBody Dungeon newDungeon, HttpServletRequest httprequest){

		Dungeon result = dungeonCommandService.updateDungeon(dungeonId, newDungeon);
		return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK,"던전 수정 완료",result));
	}

	@DeleteMapping(value = "/{dungeonId}")
	public ResponseEntity<?> dungeonDelete(@PathVariable("dungeonId") Long dungeonId, HttpServletRequest httprequest){
		dungeonCommandService.removeDungeon(dungeonId);
		return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK,"던전 삭제 성공",null));
	}


}
