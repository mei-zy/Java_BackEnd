package com.zerobase.fastlms.admin.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {
    String userId;
    String userName;
    String password;
    String phone;
    LocalDateTime regDt;

    LocalDateTime emailAuthDt;
    String emailAuthKey;
    boolean emailAuthYn;


    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;
    boolean adminYn;

    //추가 칼럼
    long totalCount;
    long seq;

}
