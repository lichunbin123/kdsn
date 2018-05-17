package com.usping.kdsn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Test
    public void testSendMail() {

        javaMailSender.setUsername("598850098@qq.com");
        javaMailSender.setPassword("ldygdifmueyobbii");
        javaMailSender.setPort(25);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("go@usping.cn");
        message.setTo("1994wangning@gmail.com");
        message.setSubject("Para test");
        message.setText("Hola, mundo!");
        javaMailSender.send(message);
    }
}
