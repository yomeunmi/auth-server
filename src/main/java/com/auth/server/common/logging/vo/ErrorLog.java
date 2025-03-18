package com.auth.server.common.logging.vo;

import com.auth.server.common.logging.util.AuthLogUtil;
import com.auth.server.common.type.LogType;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
public class ErrorLog extends BaseLog {

    private final String path;
    private final String method;
    private final JSONObject params;
    private final JSONObject headers;

    private final String exceptionType;
    private final String errorMessage;
    private final HttpStatus httpStatus;
    private final String authToken;
    private final StackTraceElement[] exception;

    public ErrorLog(Exception exception, HttpServletRequest httpServletRequest) {
        super();
        this.logType = LogType.ERROR;
        this.path = httpServletRequest.getRequestURI().replaceAll("/+", "/");
        this.params = AuthLogUtil.getParams(httpServletRequest);
        this.headers = AuthLogUtil.getHeaders(httpServletRequest);
        this.exceptionType = exception.getClass().getSimpleName();
        this.errorMessage = exception.getMessage();
        this.method = httpServletRequest.getMethod();
        this.httpStatus = ObjectUtils.isEmpty(AuthLogUtil.getHttpErrorStatus()) ? HttpStatus.INTERNAL_SERVER_ERROR : AuthLogUtil.getHttpErrorStatus();
        this.authToken = httpServletRequest.getHeader("X-Auth-Token");
        this.exception = exception.getStackTrace();
    }
}