package com.auth.server.common.logging.util;

import com.auth.server.common.logging.vo.ErrorLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.json.simple.JSONObject;
import org.springframework.util.ObjectUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

public class AuthLogUtil {
    protected static Logger infoLogger = LoggerFactory.getLogger("info");
    protected static Logger errorLogger = LoggerFactory.getLogger("error");
    protected static Logger errorAlertLogger = LoggerFactory.getLogger("error_alert");
    protected static final ThreadLocal<String> requestIdThreadLocal = new ThreadLocal();
    protected static final ThreadLocal<HttpStatus> httpErrorStatusThreadLocal = new ThreadLocal<>();

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .registerModule(new JavaTimeModule());

    public AuthLogUtil() {
    }

    public static void writeErrorLog(ErrorLog log) {
        try {
            errorLogger.error(objectMapper.writeValueAsString(log));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static String getRequestId() {
        String requestId = requestIdThreadLocal.get();
        return !ObjectUtils.isEmpty(requestId) ? requestId : newRequestId();
    }

    private static String newRequestId() {
        String requestId = UUID.randomUUID().toString();
        requestIdThreadLocal.set(requestId);
        return requestId;
    }

    public static HttpStatus getHttpErrorStatus() {
        HttpStatus httpStatus = httpErrorStatusThreadLocal.get();
        return ObjectUtils.isEmpty(httpStatus) ? HttpStatus.INTERNAL_SERVER_ERROR : httpStatus;
    }


    public static JSONObject getParams(HttpServletRequest httpServletRequest) {
        JSONObject jsonObject = new JSONObject();
        Enumeration<String> params = httpServletRequest.getParameterNames();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            String replaceParam = param.replaceAll("\\.", "-");
            jsonObject.put(replaceParam, httpServletRequest.getParameter(param));
        }
        return jsonObject;
    }

    public static JSONObject getHeaders(HttpServletRequest httpServletRequest) {
        JSONObject jsonObject = new JSONObject();
        Enumeration<String> headers = httpServletRequest.getHeaderNames();
        while ((headers.hasMoreElements())) {
            String header = headers.nextElement();
            String replaceHeader = header.replaceAll("\\.", "-");
            jsonObject.put(replaceHeader, httpServletRequest.getHeader(header));
        }

        return jsonObject;
    }

    public static long getTimeMills() {
        String timeMills = MDC.get("timeMills");
        long startTimeMills = timeMills == null ? System.currentTimeMillis() : Long.parseLong(timeMills);
        return System.currentTimeMillis() - startTimeMills;
    }
}
