package com.usping.kdsn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ning on 18-3-8.
 * @project kdsn
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KdsnApplication.class)
public class MailTest {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("$(spring.mail.username)")
    private String username;

    @Test
    public void testSendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo("1994wangning@gmail.com");
        message.setSubject("Para test");
        message.setText("Hola, mundo!");
        javaMailSender.send(message);
    }
}
