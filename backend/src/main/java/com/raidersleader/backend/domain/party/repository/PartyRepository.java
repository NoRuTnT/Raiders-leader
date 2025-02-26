package com.raidersleader.backend.domain.party.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raidersleader.backend.common.model.type.ProgressType;
import com.raidersleader.backend.domain.party.model.entity.Party;


public interface PartyRepository extends JpaRepository<Party,Long> {
	@Query("SELECT p FROM Party p JOIN FETCH p.dungeon")
	List<Party> findAll();

	@Query("SELECT p FROM Party p JOIN FETCH p.dungeon WHERE p.partyId = ?1")
	Optional<Party> findByPartyId(Long partyId);

	@Query("SELECT p FROM Party p JOIN FETCH p.dungeon WHERE p.dungeon.dungeonId = ?1")
	List<Party> findByDungeonId(Long dungeonId);

	@Query("SELECT p FROM Party p JOIN FETCH p.dungeon WHERE p.progress = ?1")
	List<Party> findAllByProgress(ProgressType progressType);

	@Query("SELECT p FROM Party p JOIN FETCH p.dungeon WHERE p.dungeon.dungeonId = ?1 and p.progress = ?2")
	List<Party> findAllByDungeonIdAndProgress(Long dungeonId, ProgressType progressType);
}
