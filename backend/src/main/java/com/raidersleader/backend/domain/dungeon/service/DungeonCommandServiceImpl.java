package com.raidersleader.backend.domain.dungeon.service;

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
	public Dungeon addDungeon(Dungeon dungeon) {
		dungeonRepository.save(dungeon);
		log.info("Dungeon {} added", dungeon);
		return dungeon;
	}

	@Override
	public void removeDungeon(Long dungeonId){
		Dungeon dungeon = dungeonRepository.findByDungeonId(dungeonId)
			.orElseThrow(()-> new DungeonNotExistException(dungeonId));

		dungeonRepository.delete(dungeon);
		log.info("Dungeon {} deleted", dungeonId);
	}

	@Override
	public Dungeon updateDungeon(Long dungeonId, Dungeon newDungeon){
		Dungeon targetDungeon = dungeonRepository.findByDungeonId(dungeonId)
			.orElseThrow(()-> new DungeonNotExistException(dungeonId));

		targetDungeon.updateDungeon(newDungeon);
		log.info("Dungeon {} modified", dungeonId);
		return newDungeon;
	}





}
