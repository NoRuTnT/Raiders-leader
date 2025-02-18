package com.raidersleader.backend.domain.dungeon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raidersleader.backend.domain.dungeon.entity.Dungeon;

public interface DungeonRepository extends JpaRepository<Dungeon,Long> {
	Optional<Dungeon> findByDungeonId(Long dungeonId);

	List<Dungeon> findAll();
}
