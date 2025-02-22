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

	@ManyToOne(fetch = FetchType.LAZY)
	private Dungeon dungeon;

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


	public void updateParty(Party party) {
		this.dungeon = party.getDungeon();
		this.memberId1 = party.getMemberId1();
		this.memberId2 = party.getMemberId2();
		this.memberId3 = party.getMemberId3();
		this.memberId4 = party.getMemberId4();
		this.progress = party.getProgress();

	}
}
