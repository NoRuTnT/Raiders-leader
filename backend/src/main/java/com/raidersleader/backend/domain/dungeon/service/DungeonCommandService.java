package com.raidersleader.backend.domain.dungeon.service;

import java.util.List;

public interface DungeonCommandService {
	String addDungeon(String dungeonName);
	void removeDungeon(Long dungeonId);
	String updateDungeon(Long dungeonId, String newDungeonName);

}
