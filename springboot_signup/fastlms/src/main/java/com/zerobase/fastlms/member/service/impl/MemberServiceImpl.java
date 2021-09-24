package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.MailComponents;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;

    @Override
    public boolean register(MemberInput parameter) {

        //동일한 ID가 존재하는지 확인해줘야한다.

        Optional<Member> optionalMember=memberRepository.findById(parameter.getUserId());
        if(optionalMember.isPresent()){
            //데이터가 있다는 것은 현재 userId의 해당하는 데이터가 존재 -> 업데이트 하면 안됌
            return false;
        }
        String uuid=UUID.randomUUID().toString();
        Member member=Member.builder()
                .userId(parameter.getUserId())
                .userName(parameter.getUserName())
                .phone(parameter.getPhone())
                .password(parameter.getPassword())
                .regDt(LocalDateTime.now())
                .emailAuthYn(false)
                .emailAuthKey(uuid)
                .build();

        member.setEmailAuthYn(false);
        //회원가입할 때는 처음 인증 - false로

        memberRepository.save(member);

        String email=parameter.getUserId();
        String subject="fastlms 사이트 가입을 축하드립니다.";
        String text="<p>fastlms 사이트 가입을 축하드립니다.</p><p>아래 링크를 클릭하셔서 가입을 완료하세요<p>"
                + "<div><a target='_blank' href='http://localhost:8080/member/email-auth?id="+uuid+"'>가입 완료</a></div>";
        mailComponents.sendMail(email,subject,text);
        return true;
    }

    @Override
    public boolean emailAuth(String uuid) {
        Optional<Member> optionalMember=memberRepository.findByEmailAuthKey(uuid);
        if(!optionalMember.isPresent()){
            return false;
        }
        Member member=optionalMember.get();
        member.setEmailAuthYn(true);
        member.setEmailAuthDt(LocalDateTime.now());
        memberRepository.save(member);
        return true;
    }
    //memberservice implement
}
