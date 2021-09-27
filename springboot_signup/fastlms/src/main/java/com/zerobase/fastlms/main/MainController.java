package com.zerobase.fastlms.main;


import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.member.entity.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.RequestUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;
    @RequestMapping("/")
    public String index(HttpServletRequest request) {

        /*사용자의 userAgent 정보 가져오기*/
        String userAgent= RequestUtils.getUserAgent(request);
        /*사용자의 Ip 가져오기*/
        String clientIp=RequestUtils.getClientIp(request);

        /*userAgent 정보 및 IP 정보 확인*/
        System.out.println(clientIp);
        System.out.println(userAgent);

        return "index";
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }
}
