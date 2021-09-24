package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.model.MemberInput;

public interface MemberService {

    boolean register(MemberInput parameter);
        /*가입할 때 입력하는 parameter */

    //uuid 넘겨주면 계정 활성화
    boolean emailAuth(String uuid);

}
