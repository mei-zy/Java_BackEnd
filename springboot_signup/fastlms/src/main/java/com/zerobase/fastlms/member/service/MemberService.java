package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput parameter);
        /*가입할 때 입력하는 parameter */

    //uuid 넘겨주면 계정 활성화
    boolean emailAuth(String uuid);

    //입력한 이메일로 비밀번호 초기화 정보를 전송하는 메소드
    boolean sendResetPassword(ResetPasswordInput parameter);
    //비밀번호 초기화
    boolean resetPassword(String uuid, String password);

    //입력받은 uuid 값이 유효한지 체크
    boolean checkResetPassword(String uuid);

    /*회원의 목록을 리턴(관리자에서만 사용가능)*/
    List<MemberDto> list(MemberParam parameter);

}
