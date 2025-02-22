package com.raidersleader.backend.domain.party.model.dto;

import com.raidersleader.backend.domain.dungeon.entity.Dungeon;
import com.raidersleader.backend.domain.party.model.entity.Party;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PartyRequestDto {
	private Dungeon dungeon;
	private String memberId1;
	private String memberId2;
	private String memberId3;
	private String memberId4;

	public PartyRequestDto(Party party) {
		this.dungeon = party.getDungeon();
		this.memberId1 = party.getMemberId1();
		this.memberId2 = party.getMemberId2();
		this.memberId3 = party.getMemberId3();
		this.memberId4 = party.getMemberId4();

	}
}
