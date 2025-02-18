package com.raidersleader.backend.domain.party.model.entity;

import com.raidersleader.backend.common.model.type.ProgressType;
import com.raidersleader.backend.domain.dungeon.entity.Dungeon;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "party")
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long partyId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Dungeon dungeonName;

	private String memberId1;

	@Nullable
	private String memberId2;

	@Nullable
	private String memberId3;

	@Nullable
	private String memberId4;

	@Enumerated(value = EnumType.STRING)
	private ProgressType progress;

}
