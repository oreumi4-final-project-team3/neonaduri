package com.est.neonaduri.global.infra.emailapi.service;

import com.est.neonaduri.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EmailApi {
    private final JavaMailSender emailSender;
    private final UserRepository userRepository; // 이후에 예약자 유저정보 사용

    /**
     * email 발송 기능 (게시글 작성자에게 알림 용)
     */
    public void sendEmail() {
        String toEmail="shlim0287@naver.com";
        String title="동행 게시글에 예약이 신청되었습니다!";
        String text="동행 게시글에 예약이 신청되었습니다! 확인해주세요 ~";
        SimpleMailMessage emailForm = createEmailForm(toEmail, title, text);
        try {
            emailSender.send(emailForm);
        } catch (RuntimeException e) {
            log.info("에러 발생",e.getMessage());
            throw new IllegalArgumentException("잘못된 입력값");
        }
    }

    // 발신할 이메일 데이터 세팅
    private SimpleMailMessage createEmailForm(String toEmail,
                                              String title,
                                              String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(title);
        message.setText(text);

        return message;
    }

}
