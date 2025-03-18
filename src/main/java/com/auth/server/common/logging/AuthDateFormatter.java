package com.auth.server.common.logging;

import java.time.format.DateTimeFormatter;

public class AuthDateFormatter {

    public static DateTimeFormatter yyyyMmDdHhMmSsFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter yyyyMMddFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter yyyyMmDdHhMmssFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyyMM");
    public static DateTimeFormatter yyyyMmDdHhMmSsFffFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMdd = "yyyyMMdd";


}
