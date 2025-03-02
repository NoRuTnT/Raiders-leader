package com.raidersleader.backend.domain.dungeon.service;

import java.util.List;

import com.raidersleader.backend.domain.dungeon.dto.DungeonDto;

public interface DungeonQueryService {
	List<DungeonDto> findAllDungeons();
}
