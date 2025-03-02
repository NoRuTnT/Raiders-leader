package com.raidersleader.backend.domain.character.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raidersleader.backend.domain.character.common.exception.CharacterNotExistException;
import com.raidersleader.backend.domain.character.model.dto.CharacterDetailResponseDto;
import com.raidersleader.backend.domain.character.model.entity.Character;
import com.raidersleader.backend.domain.character.repository.CharacterRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CharacterQueryServiceImpl implements CharacterQueryService {
	private final CharacterRepository characterRepository;

	public List<CharacterDetailResponseDto> findAllCharacters(){
		return characterRepository.findAll()
			.stream()
			.map(character -> new CharacterDetailResponseDto(character))
			.collect(Collectors.toList());
	}

	@Override
	public List<CharacterDetailResponseDto> findAdventureCharacterList(String adventureName){

		return characterRepository.findByAdventureName(adventureName)
			.stream()
			.map(character -> new CharacterDetailResponseDto(character))
			.collect(Collectors.toList());

	}

	@Override
	public CharacterDetailResponseDto findCharacterDetailByName(String characterName){
		Character character = characterRepository.findByCharacterName(characterName).orElseThrow(()-> new CharacterNotExistException(characterName));

		return new CharacterDetailResponseDto(character);
	}

}
