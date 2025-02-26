package com.raidersleader.backend.domain.character.common.exception;

import com.raidersleader.backend.common.exception.BadRequestException;

public class CharacterNotExistException extends BadRequestException {
	private static final String MESSAGE = "존재하지 않는  캐릭터입니다. CharacterId: %s";
	public CharacterNotExistException(String characterId) {
		super(String.format(MESSAGE, characterId));
	}
}
