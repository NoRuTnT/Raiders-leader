package com.raidersleader.backend.domain.character.model.dto;

import lombok.Data;
import com.raidersleader.backend.domain.character.model.entity.Character;

@Data
public class CharacterDetailResponseDto {
	private String characterId;
	private String serverId;
	private String characterName;
	private String jobGrowName;
	private long fame;
	private String adventureName;

	public CharacterDetailResponseDto(Character character) {
		this.characterId = character.getCharacterId();
		this.serverId = character.getServerId();
		this.characterName = character.getCharacterName();
		this.jobGrowName = character.getJobGrowName();
		this.fame = character.getFame();
		this.adventureName = character.getAdventureName();
	}

}
