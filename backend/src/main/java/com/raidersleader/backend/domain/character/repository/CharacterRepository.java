package com.raidersleader.backend.domain.character.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raidersleader.backend.domain.character.model.entity.Character;

public interface CharacterRepository extends JpaRepository<Character,Long> {

	Optional<Character> findByAdventureName(String adventureName);
	Optional<Character> findByCharacterName(String characterName);
	Optional<Character> findByCharacterId(String characterId);


}
