package com.auth.server.common.exception;

import com.auth.server.common.type.ErrorReason;
import com.auth.server.controller.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class AuthTokenIncorrectException extends ServiceException {

	static final HttpStatus RESPONSE_CODE = HttpStatus.UNAUTHORIZED;
	static final ErrorReason ERROR_REASON = ErrorReason.UnAuthorized;
	static final int ERROR_CODE = 1201;

	public AuthTokenIncorrectException(int responseCode, String responseMsg, String authToken, Throwable cause) {
		super(RESPONSE_CODE,
				ERROR_REASON,
				ERROR_CODE,
				String.format("Authentication is failed. token: %s", authToken), cause);

		this.errorResponseDto = ErrorResponseDto.builder()
				.errorCode(ERROR_CODE)
				.responseCode(String.valueOf(responseCode))
				.responseMessage(responseMsg)
				.build();

	}
}
