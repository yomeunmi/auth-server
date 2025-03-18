package com.auth.server.common.logging.vo;

import com.auth.server.common.logging.AuthDateFormatter;
import com.auth.server.common.logging.util.AuthLogUtil;
import com.auth.server.common.type.LogType;
import com.auth.server.component.ProfileManager;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BaseLog {

    protected LogType logType = LogType.INFO;
    private final String profile;
    private String txId;
    private final String time;
    private final long responseMills;

    public BaseLog() {
        super();
        this.profile = ProfileManager.profileName;
        this.txId = AuthLogUtil.getRequestId();
        this.time = LocalDateTime.now().format(AuthDateFormatter.yyyyMmDdHhMmSsFormatter);
        this.responseMills = AuthLogUtil.getTimeMills();
    }

    public BaseLog(String txId) {
        this.profile = ProfileManager.profileName;
        this.txId = txId;
        this.time = LocalDateTime.now().format(AuthDateFormatter.yyyyMmDdHhMmSsFormatter);
        this.responseMills = AuthLogUtil.getTimeMills();
    }

    public BaseLog(LogType logType, String profile, String txId, long startTime) {
        this.logType = logType;
        this.profile = profile;
        this.txId = txId;
        this.time = LocalDateTime.now().format(AuthDateFormatter.yyyyMmDdHhMmSsFormatter);
        this.responseMills = System.currentTimeMillis() - startTime;
    }
}