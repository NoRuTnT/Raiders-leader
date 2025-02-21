package com.raidersleader.backend.domain.character.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raidersleader.backend.domain.character.common.exception.CharacterNotExistException;
import com.raidersleader.backend.domain.character.model.entity.Character;
import com.raidersleader.backend.domain.character.repository.CharacterRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CharacterCommandServiceImpl implements CharacterCommandService {
	private final CharacterRepository characterRepository;


	public Character addCharacter(Character character){


		return characterRepository.save(character);

	}

	public Character updateCharacter(String characterId, Character character){

		Character charactertmp = characterRepository.findByCharacterId(characterId)
			.orElseThrow(()-> new CharacterNotExistException(characterId));

		charactertmp.update(character);

		return charactertmp;
	}


}
