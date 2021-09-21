package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.model.MemberInput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MemberController {

    @GetMapping("/member/register")
    public String register(){

        return "member/register";
    }
    /*새로고침하면 get으로,
    회원가입 button 누르면 post로
     */
    @PostMapping("/member/register")
    public String registerSubmit(HttpServletRequest request, HttpServletResponse response, MemberInput parameter){
        /*Request 는 Web-> Server로
        Response는 Server-> Web으로*/

        System.out.println(parameter.toString());


        return "member/register";
    }


}
