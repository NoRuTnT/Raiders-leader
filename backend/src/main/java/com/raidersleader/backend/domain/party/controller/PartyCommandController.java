package com.raidersleader.backend.domain.party.controller;

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
import com.raidersleader.backend.domain.party.model.dto.PartyDto;
import com.raidersleader.backend.domain.party.model.dto.PartyResponseDto;
import com.raidersleader.backend.domain.party.service.PartyCommandService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/party")
@RestController
public class PartyCommandController {
	private final PartyCommandService partyCommandService;

	@PostMapping
	public ResponseEntity<?> partyAdd(@RequestBody PartyDto party, HttpServletRequest httprequest){

		PartyResponseDto result = partyCommandService.addParty(party);
		return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK,"파티 등록 성공",result));
	}

	@PutMapping(value = "/{partyId}")
	public ResponseEntity<?> partyUpdate(@PathVariable("partyId") Long partyId, @RequestBody PartyDto party, HttpServletRequest httprequest){

		PartyResponseDto result = partyCommandService.updateParty(partyId, party);
		return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK,"파티 변경 완료",result));
	}

	@DeleteMapping(value = "/{partyId}")
	public ResponseEntity<?> partyDelete(@PathVariable("partyId") Long partyId, HttpServletRequest httprequest){
		partyCommandService.removeParty(partyId);
		return ResponseEntity.ok(new SuccessResponse(HttpStatus.OK,"파티 삭제 성공",null));
	}
}
