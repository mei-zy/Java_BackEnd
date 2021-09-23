package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String register(){

        return "member/register";
    }
    /*새로고침하면 get으로,
    회원가입 button 누르면 post로
     */
    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request, MemberInput parameter){
        /*Request 는 Web-> Server로
        Response는 Server-> Web으로*/


        /*repository에 save
        Member member=new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPhone(parameter.getPassword());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);
        -> 여길 MemberService를 통해 가능
         */
        boolean result=memberService.register(parameter);
        model.addAttribute("result",result);
        //member/register-complete에서 result에 대한 값 결정 가능
        return "member/register-complete";
    }


}
