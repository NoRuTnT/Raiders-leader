package com.raidersleader.backend.domain.party.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raidersleader.backend.common.model.dto.SuccessResponse;
import com.raidersleader.backend.domain.party.model.dto.PartyResponseDto;
import com.raidersleader.backend.domain.party.service.PartyQueryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/party")
@RestController
public class PartyQueryController {
	private final PartyQueryService partyQueryService;

	@GetMapping("/search/{partyId}")
	public ResponseEntity<?> searchParty(@PathVariable("partyId") Long partyId){
		PartyResponseDto result = partyQueryService.findPartyById(partyId);

		return ResponseEntity.ok(SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(result)
				.build());
	}

	@GetMapping
	public ResponseEntity<SuccessResponse> allPartyList(){
		List<PartyResponseDto> result = partyQueryService.findAllParties();

		return ResponseEntity.ok(SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(result)
				.build());
	}

	@GetMapping("/waiting")
	public ResponseEntity<SuccessResponse> allPartyWaitingList(){
		List<PartyResponseDto> result = partyQueryService.findAllInProgressList();
		return ResponseEntity.ok(SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(result)
				.build());

	}

	@GetMapping("/{dungeonId}")
	public ResponseEntity<SuccessResponse> dungeonPartyList(@PathVariable("dungeonId") Long dungeonId){
		List<PartyResponseDto> result = partyQueryService.findPartiesByDungeonId(dungeonId);
		return ResponseEntity.ok(SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(result)
				.build());
	}

	@GetMapping("/waiting/{dungeonId}")
	public ResponseEntity<SuccessResponse> dungeonPartyWaitingList(@PathVariable("dungeonId") Long dungeonId){
		List<PartyResponseDto> result = partyQueryService.findPartiesInProgressListByDungeonId(dungeonId);

		return ResponseEntity.ok(SuccessResponse.builder()
				.status(HttpStatus.OK)
				.result(result)
				.build());

	}


}
