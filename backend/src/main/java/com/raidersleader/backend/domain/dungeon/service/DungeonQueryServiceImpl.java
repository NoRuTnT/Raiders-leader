package com.raidersleader.backend.domain.dungeon.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raidersleader.backend.domain.dungeon.entity.Dungeon;
import com.raidersleader.backend.domain.dungeon.repository.DungeonRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DungeonQueryServiceImpl implements DungeonQueryService {
	private final DungeonRepository dungeonRepository;

	@Override
	public List<String> findAllDungeons() {
		List<Dungeon> dungeons = dungeonRepository.findAll();

		return dungeons.stream()
			.map(dungeon -> dungeon.getDungeonName())
			.toList();
	}
}
