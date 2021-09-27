package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.model.ResetPasswordInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

    //http://www.naver.com/news/list.do 가 원래 주소
    //http://www.naver.com/id=? 물음표는 parameter

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model,HttpServletRequest request){
        //parameter을 받는 법
        String uuid=request.getParameter("id");
        System.out.println(uuid);

        boolean result=memberService.emailAuth(uuid);
        model.addAttribute("result",result);

        return "member/email.auth";

    }
    @GetMapping("/member/info")
    public String memberInfo(){
        return "member/info";

    }

    @RequestMapping("/member/login")
    public String login(){

        return "member/login";
    }

    @GetMapping("/member/find/password")
    public String findPassword(){
        return "member/find_password";
    }

    @PostMapping("/member/find/password")
    public String findPasswordSubmit(Model model,ResetPasswordInput parameter){
        boolean result=false;
        try{
            result=memberService.sendResetPassword(parameter);
        }catch(Exception e){

        }
        model.addAttribute("result",result);
        return "member/find_password_result";
    }

    @GetMapping("/member/reset/password")
    public String resetPassword(Model model,HttpServletRequest request){
        String uuid=request.getParameter("id");

        //uuid가 정말 유효한지 체크해줘야한다.
        boolean result=memberService.checkResetPassword(uuid);
        model.addAttribute("result",result);
        return "member/reset_password";
    }

    @PostMapping("/member/reset/password")
    public String resetPasswordSubmit(Model model, ResetPasswordInput parameter){
        boolean result=false;
        try{
            result=memberService.resetPassword(parameter.getId(),parameter.getPassword());
        }catch (Exception e){

        }
        model.addAttribute("result",result);
        return "member/reset_password_result";
    }


}
