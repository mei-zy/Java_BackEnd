package com.zerobase.fastlms;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;
    @RequestMapping("/")
    public String index() {
        String email="hihigh970502@naver.com";
        String subject="안녕하세요";
        String text="hello";
        mailComponents.sendMail(email,subject,text);
        return "index";
    }
}
