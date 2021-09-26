package com.zerobase.fastlms.configuration;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String msg="로그인에 실패하였습니다.";
        if(exception instanceof Exception){
            msg=exception.getMessage();
        }
        //rg.springframework.security.authentication.InternalAuthenticationServiceException: 이메일을 활성화 이후에 로그인을 해주세요.

        //에러발생했으니까 REQUEST 메세지로 에러 메세지
        setUseForward(true);
        setDefaultFailureUrl("/member/login?error=true");
        request.setAttribute("errorMessage",msg);
        System.out.println("로그인 실패");
        super.onAuthenticationFailure(request, response, exception);
    }
}
