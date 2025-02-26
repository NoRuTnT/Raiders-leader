package com.raidersleader.backend.domain.party.service;

import java.util.List;

import com.raidersleader.backend.domain.party.model.dto.PartyResponseDto;

public interface PartyQueryService {
	PartyResponseDto findPartyById(Long partyId);

	List<PartyResponseDto> findAllParties();

	List<PartyResponseDto> findPartiesByDungeonId(Long dungeonId);

	List<PartyResponseDto> findAllInProgressList();

	List<PartyResponseDto> findPartiesInProgressListByDungeonId(Long dungeonId);

}
