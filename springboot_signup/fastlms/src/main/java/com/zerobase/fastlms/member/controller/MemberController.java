package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;
    public MemberController(MemberRepository memberRepository){

        this.memberRepository=memberRepository;
    }
    @GetMapping("/member/register")
    public String register(){

        return "member/register";
    }
    /*새로고침하면 get으로,
    회원가입 button 누르면 post로
     */
    @PostMapping("/member/register")
    public String registerSubmit(HttpServletRequest request, MemberInput parameter){
        /*Request 는 Web-> Server로
        Response는 Server-> Web으로*/

        System.out.println(parameter.toString());

        /*repository에 save*/
        Member member=new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPhone(parameter.getPassword());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);


        return "member/register-complete";
    }


}
