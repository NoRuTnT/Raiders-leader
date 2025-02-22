package com.raidersleader.backend.domain.party.model.dto;

import com.raidersleader.backend.common.model.type.ProgressType;
import com.raidersleader.backend.domain.dungeon.entity.Dungeon;
import com.raidersleader.backend.domain.party.model.entity.Party;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PartyResponseDto {
	private Dungeon dungeon;
	private String memberId1;
	private String memberId2;
	private String memberId3;
	private String memberId4;
	private ProgressType progress;

	public PartyResponseDto(Party party) {
		this.dungeon = party.getDungeon();
		this.memberId1 = party.getMemberId1();
		this.memberId2 = party.getMemberId2();
		this.memberId3 = party.getMemberId3();
		this.memberId4 = party.getMemberId4();
		this.progress = party.getProgress();
	}
}
