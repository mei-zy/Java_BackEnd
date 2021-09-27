package com.zerobase.fastlms.components;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class MailComponents {
    private final JavaMailSender javaMailSender;
    public void sendMailTest(){
        /*메일 보내는 메소드*/

        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo("alswlkku@ajou.ac.kr");
        msg.setSubject("welcome to zerobase");
        msg.setText("hello world");
        javaMailSender.send(msg);
    }

    public void sendMail(String mail,String subject,String text){
        /*더 자세하게 메일을 보내는 방식*/
        boolean result=false;
        MimeMessagePreparator msg=new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setTo(mail);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(text, true);
            }
        };
        try{
            javaMailSender.send(msg);
            result=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        result=false;
    }
}
