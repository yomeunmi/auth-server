package com.auth.server.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class ProfileManager {

    @Value("${profile:}")
    String profile;

    public static String profileName = "";

    @PostConstruct
    public void init() {
        profileName = profile;
    }

    public boolean isLocal() {
        return "local".equals(profile);
    }
    public boolean isDev() {
        return "dev".equals(profile);
    }
    public boolean isStg() {
        return "stg".equals(profile);
    }
    public boolean isPrd() {
        return "prd".equals(profile);
    }
    public boolean isNotPrd() {
        return !"prd".equals(profile);
    }
    public boolean isNotStg() {
        return !"stg".equals(profile);
    }
}
