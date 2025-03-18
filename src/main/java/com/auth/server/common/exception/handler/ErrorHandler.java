package com.auth.server.common.exception.handler;

import com.auth.server.common.exception.AuthTokenIncorrectException;
import com.auth.server.common.exception.ServiceException;
import com.auth.server.common.logging.util.AuthLogUtil;
import com.auth.server.component.ProfileManager;
import com.auth.server.controller.dto.ErrorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.auth.server.common.logging.vo.ErrorLog;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {

    private final ProfileManager profileManager;

    @ExceptionHandler({
        AuthTokenIncorrectException.class
    })
    public ResponseEntity<ErrorResponseDto> handleTokenException(ServiceException exception, HttpServletRequest request) {
        AuthLogUtil.writeErrorLog(new ErrorLog(exception, request));
        return new ResponseEntity<>(exception.getErrorResponseDto(), HttpStatus.UNAUTHORIZED);
    }
}
