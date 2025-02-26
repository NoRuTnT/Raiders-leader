package com.raidersleader.backend.domain.character.service;

import com.raidersleader.backend.domain.character.model.entity.Character;

public interface CharacterCommandService {

	Character addCharacter(Character character);

	Character updateCharacter(String characterId, Character character);

}
