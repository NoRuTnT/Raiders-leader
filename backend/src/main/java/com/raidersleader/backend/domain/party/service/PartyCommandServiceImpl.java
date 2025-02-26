package com.raidersleader.backend.domain.party.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raidersleader.backend.common.model.type.ProgressType;
import com.raidersleader.backend.domain.party.common.exception.PartyNotExistException;
import com.raidersleader.backend.domain.party.model.dto.PartyDto;
import com.raidersleader.backend.domain.party.model.dto.PartyResponseDto;
import com.raidersleader.backend.domain.party.model.entity.Party;
import com.raidersleader.backend.domain.party.repository.PartyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PartyCommandServiceImpl implements PartyCommandService {
	private final PartyRepository partyRepository;

	@Override
	public PartyResponseDto addParty(PartyDto party){

		Party newParty = Party.builder()
			.dungeon(party.getDungeon())
			.memberId1(party.getMemberId1())
			.memberId2(Optional.ofNullable(party.getMemberId2()).orElse(null))
			.memberId3(Optional.ofNullable(party.getMemberId3()).orElse(null))
			.memberId4(Optional.ofNullable(party.getMemberId4()).orElse(null))
			.progress(ProgressType.WAITING)
			.build();

		partyRepository.save(newParty);

		return PartyResponseDto.builder()
			.dungeon(newParty.getDungeon())
			.memberId1(newParty.getMemberId1())
			.memberId2(Optional.ofNullable(newParty.getMemberId2()).orElse(null))
			.memberId3(Optional.ofNullable(newParty.getMemberId3()).orElse(null))
			.memberId4(Optional.ofNullable(newParty.getMemberId4()).orElse(null))
			.progress(party.getProgress())
			.build();
	}

	@Override
	public PartyResponseDto updateParty(Long partyId, PartyDto party){

		Party targetParty = partyRepository.findByPartyId(partyId)
			.orElseThrow(()-> new PartyNotExistException(partyId));

		Party newParty = Party.builder()
			.dungeon(party.getDungeon())
			.memberId1(party.getMemberId1())
			.memberId2(Optional.ofNullable(party.getMemberId2()).orElse(null))
			.memberId3(Optional.ofNullable(party.getMemberId3()).orElse(null))
			.memberId4(Optional.ofNullable(party.getMemberId4()).orElse(null))
			.progress(party.getProgress())
			.build();

		targetParty.updateParty(newParty);

		return PartyResponseDto.builder()
			.dungeon(newParty.getDungeon())
			.memberId1(newParty.getMemberId1())
			.memberId2(Optional.ofNullable(newParty.getMemberId2()).orElse(null))
			.memberId3(Optional.ofNullable(newParty.getMemberId3()).orElse(null))
			.memberId4(Optional.ofNullable(newParty.getMemberId4()).orElse(null))
			.progress(party.getProgress())
			.build();
	}

	@Override
	public void removeParty(Long partyId){
		Party targetParty = partyRepository.findByPartyId(partyId)
			.orElseThrow(() -> new PartyNotExistException(partyId));
		partyRepository.delete(targetParty);
	}
}
