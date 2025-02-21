package com.raidersleader.backend.domain.character.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "`character`")
public class Character {

	@Id
	@Column(name = "character_id")
	private String characterId;

	@Column(name = "server_id")
	private String serverId;

	@Column(name = "character_name")
	private String characterName;

	private long level;

	@Column(name = "job_id")
	private String jobId;

	@Column(name = "jobgrow_id")
	private String jobGrowId;

	@Column(name = "job_name")
	private String jobName;

	@Column(name = "jobgrow_name")
	private String jobGrowName;

	private long fame;

	@Column(name = "adventure_name")
	private String adventureName;

	@Column(name = "guild_id")
	private String guildId;

	@Column(name = "guild_name")
	private String guildName;

	public void update(Character character){
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
