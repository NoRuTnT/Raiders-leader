package com.raidersleader.backend.domain.character.model.dto;

import com.raidersleader.backend.domain.character.model.entity.Character;

import lombok.Data;

@Data
public class CharacterDetailResponseDto {
	private String characterId;
	private String serverId;
	private String characterName;
	private long level;
	private String jobGrowName;
	private long fame;
	private String adventureName;

	public CharacterDetailResponseDto(Character character) {
		this.characterId = character.getCharacterId();
		this.serverId = character.getServerId();
		this.characterName = character.getCharacterName();
		this.level = character.getLevel();
		this.jobGrowName = character.getJobGrowName();
		this.fame = character.getFame();
		this.adventureName = character.getAdventureName();
	}

}
