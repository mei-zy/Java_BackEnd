package com.zerobase.fastlms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
