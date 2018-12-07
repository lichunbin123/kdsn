package com.usping.kdsn;

import com.usping.kdsn.service.serviceImpl.EmailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ning on 18-3-8.
 * @project kdsn
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KdsnApplication.class)
public class MailTest {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Value("$(spring.mail.username)")
    private String username;

    @Value("${spring.mail.password)")
    private String password;

    @Autowired
    private EmailServiceImpl emailService;

    @Test
    public void testSendMailRunner() {
        String emailAddress = "1677254199@qq.com";
        emailService.sendEmail(emailAddress);
    }
}
