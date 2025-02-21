package com.raidersleader.backend.domain.dungeon.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raidersleader.backend.domain.dungeon.common.exception.DungeonNotExistException;
import com.raidersleader.backend.domain.dungeon.entity.Dungeon;
import com.raidersleader.backend.domain.dungeon.repository.DungeonRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DungeonCommandServiceImpl implements DungeonCommandService {
	private final DungeonRepository dungeonRepository;

	@Override
	public String addDungeon(String dungeonName) {
		dungeonRepository.save(
			Dungeon.builder()
			.dungeonName(dungeonName)
			.build());
		log.info("Dungeon {} added", dungeonName);
		return dungeonName;
	}

	@Override
	public void removeDungeon(Long dungeonId){
		Dungeon dungeon = dungeonRepository.findByDungeonId(dungeonId)
			.orElseThrow(()-> new DungeonNotExistException(dungeonId));

		dungeonRepository.delete(dungeon);
		log.info("Dungeon {} deleted", dungeonId);
	}

	@Override
	public String updateDungeon(Long dungeonId, String newDungeonName){
		Dungeon dungeon = dungeonRepository.findByDungeonId(dungeonId)
			.orElseThrow(()-> new DungeonNotExistException(dungeonId));
		dungeon.updateDungeon(newDungeonName);
		log.info("Dungeon {} modified", dungeonId);
		return newDungeonName;
	}





}
