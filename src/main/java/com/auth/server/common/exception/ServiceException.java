package com.auth.server.common.exception;

import com.auth.server.common.type.ErrorReason;
import com.auth.server.controller.dto.ErrorResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@Getter
public class ServiceException extends RuntimeException {

	protected HttpStatus statusCode;
	protected ErrorReason errorReason;
	protected int responseCode;
	protected int errorCode;
	protected String clientMessage;
	protected ErrorResponseDto errorResponseDto;

	public ServiceException(HttpStatus responseCode, ErrorReason errorReason, int errorCode, String clientMessage, Throwable cause) {
		super(cause);
		this.statusCode = responseCode;
		this.errorReason = errorReason;
		this.errorCode = errorCode;
		this.clientMessage = clientMessage;
	}
}
