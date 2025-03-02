package com.raidersleader.backend.domain.character.service;

import java.util.List;

import com.raidersleader.backend.domain.character.model.dto.CharacterDetailResponseDto;

public interface CharacterQueryService {
	List<CharacterDetailResponseDto> findAllCharacters();
	List<CharacterDetailResponseDto> findAdventureCharacterList(String adventureName);
	CharacterDetailResponseDto findCharacterDetailByName(String characterName);


}
