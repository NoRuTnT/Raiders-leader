package com.raidersleader.backend.domain.dungeon.common.exception;

import com.raidersleader.backend.common.exception.BadRequestException;

public class DungeonNotExistException extends BadRequestException {
	private static final String MESSAGE = "존재하지 않는 던전입니다. dungeonNo: %d";
	public DungeonNotExistException(Long dungeonNo) {
		super(String.format(MESSAGE, dungeonNo));
	}
}
