package com.raidersleader.backend.domain.character.model.dto;

import com.raidersleader.backend.domain.character.model.entity.Character;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {
	private String characterId;

	private String serverId;

	private String characterName;

	private long level;

	private String jobId;

	private String jobGrowId;

	private String jobName;

	private String jobGrowName;

	private long fame;

	private String adventureName;

	private String guildId;

	private String guildName;

	public CharacterDto(Character character) {
		this.characterId = character.getCharacterId();
		this.serverId = character.getServerId();
		this.characterName = character.getCharacterName();
		this.level = character.getLevel();
		this.jobId = character.getJobId();
		this.jobGrowId = character.getJobGrowId();
		this.jobName = character.getJobName();
		this.jobGrowName = character.getJobGrowName();
		this.fame = character.getFame();
		this.adventureName = character.getAdventureName();
		this.guildId = character.getGuildId();
		this.guildName = character.getGuildName();
	}

}
