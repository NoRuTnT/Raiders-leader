package com.raidersleader.backend.domain.dungeon.service;

import com.raidersleader.backend.domain.dungeon.entity.Dungeon;

public interface DungeonCommandService {
	Dungeon addDungeon(Dungeon dungeon);
	void removeDungeon(Long dungeonId);
	Dungeon updateDungeon(Long dungeonId, Dungeon newDungeon);

}
