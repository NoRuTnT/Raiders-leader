package com.raidersleader.backend.domain.dungeon.dto;

import com.raidersleader.backend.domain.dungeon.entity.Dungeon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DungeonDto {
	private Long dungeonId;
	private String name;

	public DungeonDto(Dungeon dungeon) {
		this.dungeonId = dungeon.getDungeonId();
		this.name = dungeon.getName();
	}
}
