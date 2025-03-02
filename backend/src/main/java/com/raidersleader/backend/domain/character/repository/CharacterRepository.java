package com.raidersleader.backend.domain.character.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raidersleader.backend.domain.character.model.entity.Character;

public interface CharacterRepository extends JpaRepository<Character,Long> {

	List<Character> findAll();

	@Query("SELECT c FROM Character c WHERE c.adventureName = ?1")
	List<Character> findByAdventureName(String adventureName);

	@Query("SELECT c FROM Character c WHERE c.characterName = ?1")
	Optional<Character> findByCharacterName(String characterName);

	@Query("SELECT c FROM Character c WHERE c.characterId = ?1")
	Optional<Character> findByCharacterId(String characterId);


}
