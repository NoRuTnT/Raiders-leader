package com.raidersleader.backend.domain.party.model.entity;

import com.raidersleader.backend.common.model.type.ProgressType;
import com.raidersleader.backend.domain.dungeon.entity.Dungeon;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
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
	@Column(name = "party_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long partyId;

	@Column(name = "dungeon_name")
	@ManyToOne(fetch = FetchType.LAZY)
	private Dungeon dungeonName;

	@Column(name = "member_id1")
	private String memberId1;

	@Nullable
	@Column(name = "member_id2")
	private String memberId2;

	@Nullable
	@Column(name = "member_id3")
	private String memberId3;

	@Nullable
	@Column(name = "member_id4")
	private String memberId4;

	@Enumerated(value = EnumType.STRING)
	private ProgressType progress;

}
