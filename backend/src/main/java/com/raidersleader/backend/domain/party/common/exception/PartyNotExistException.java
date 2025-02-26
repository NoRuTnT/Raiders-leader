package com.raidersleader.backend.domain.party.common.exception;

import com.raidersleader.backend.common.exception.BadRequestException;

public class PartyNotExistException extends BadRequestException {
	private static final String MESSAGE = "존재하지 않는 파티입니다. partyId: %ld";
	public PartyNotExistException(Long partyId) {
		super(String.format(MESSAGE, partyId));
	}

}
