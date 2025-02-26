package com.raidersleader.backend.domain.party.service;

import com.raidersleader.backend.domain.party.model.dto.PartyDto;
import com.raidersleader.backend.domain.party.model.dto.PartyResponseDto;

public interface PartyCommandService {
	PartyResponseDto addParty(PartyDto party);

	PartyResponseDto updateParty(Long partyId, PartyDto party);

	void removeParty(Long partyId);
}
