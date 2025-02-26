package com.raidersleader.backend.domain.party.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raidersleader.backend.common.model.type.ProgressType;
import com.raidersleader.backend.domain.party.common.exception.PartyNotExistException;
import com.raidersleader.backend.domain.party.model.dto.PartyResponseDto;
import com.raidersleader.backend.domain.party.model.entity.Party;
import com.raidersleader.backend.domain.party.repository.PartyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PartyQueryServiceImpl implements PartyQueryService {
	private final PartyRepository partyRepository;

	@Override
	public PartyResponseDto findPartyById(Long partyId){
		Party party = partyRepository.findByPartyId(partyId).orElseThrow(()-> new PartyNotExistException(partyId));

		return new PartyResponseDto(party);

	}

	@Override
	public List<PartyResponseDto> findAllParties(){


		return partyRepository.findAll()
			.stream()
			.map(party -> new PartyResponseDto(party))
			.collect(Collectors.toList());
	}

	@Override
	public List<PartyResponseDto> findPartiesByDungeonId(Long dungeonId){

		return partyRepository.findByDungeonId(dungeonId)
			.stream()
			.map(party -> new PartyResponseDto(party))
			.collect(Collectors.toList());
	}

	@Override
	public List<PartyResponseDto> findAllInProgressList(){

		return partyRepository.findAllByProgress(ProgressType.WAITING)
			.stream()
			.map(party -> new PartyResponseDto(party))
			.collect(Collectors.toList());
	}

	@Override
	public List<PartyResponseDto> findPartiesInProgressListByDungeonId(Long dungeonId){

		return partyRepository.findAllByDungeonIdAndProgress(dungeonId,ProgressType.WAITING)
			.stream()
			.map(party -> new PartyResponseDto(party))
			.collect(Collectors.toList());
	}


}
