package com.raidersleader.backend.domain.dungeon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "dungeon")
public class Dungeon {

	@Id
	@Column(name = "dungeon_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dungeonId;

	private String name;

	public void updateDungeon(String name) {
		this.name = name;
	}
}