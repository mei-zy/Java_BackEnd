package com.zerobase.fastlms.member.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member {
    @Id
    private String userId;

    private String userName;
    private String phone;
    private String password;

    private LocalDateTime regDt;

    private boolean emailAuthYn;
    //이메일 인증이 완료되었는지 확인하는 변수
    private String emailAuthKey;
    //회원가입시, 키를 만들어서 이메일로 보내줘서 이메일 링크로 보내서 맞는지 확인
    private LocalDateTime emailAuthDt;
    //이메일 인증날짜

    //찾을 수 있게끔
    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;

    //관리자 여부를 지정하는 것
    private boolean adminYn;

    private String userAgent;
    private String ClientIp;
    /*Week7.과제 - IP와 UserAgent 가져오기에서 변수 추가*/
}
