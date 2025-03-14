package com.raidersleader.backend.common.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BusinessException {

	public ConflictException(final String message) {
		super(message);
	}

	@Override
	public HttpStatus status() {
		return HttpStatus.CONFLICT;
	}
}