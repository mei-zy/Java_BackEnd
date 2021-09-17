package com.zerobase.fastlms.member;

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
    public String registerSubmit(HttpServletRequest request, HttpServletResponse response){
        /*Request 는 Web-> Server로
        Response는 Server-> Web으로*/

        String userId=request.getParameter("userId");
        //값을 받아올 수 있다.
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");

        System.out.println("user Id: "+userId+" UserName: "+userName+" password: "+password+" phone : "+phone);

        return "member/register";
    }


}
