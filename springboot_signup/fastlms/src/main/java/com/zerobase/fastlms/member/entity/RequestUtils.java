package com.zerobase.fastlms.member.entity;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static String getUserAgent(HttpServletRequest request) {
        String agent=request.getHeader("user-agent");
        return agent;
    }


    public static String getClientIp(HttpServletRequest request) {
        String ip=request.getHeader("X-Forwarded-For");
        if(ip==null)
            ip=request.getRemoteAddr();

        return ip;
    }
}
