package com.usping.kdsn.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;


//public class EmailService {
//    String email;
//    public EmailService(String email)
//    {
//        this.email = email;
//    }
//    @Autowired
//    private JavaMailSender mailSender;
//    @Autowired
//    private FreeMarkerConfigurer freeMarkerConfigurer;//发送邮件的模板引擎
//    @Value("${spring.mail.username}")
//    private String username;
//    @Value("${spring.mail.password}")
//    private String password;
//    @Value("${spring.mail.host}")
//    private String host;
//    @Value("${spring.mail.properties.mail.smtp.host}")
//    private  String propshost;
//    @Value("${spring.mail.properties.mail.smtp.auth}")
//    private  String propsauth;
//   public void sendMail(){
//       MimeMessage mimeMessage = null;
//
//       try {
//           mimeMessage = mailSender.createMimeMessage();
//           MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
//           helper.setFrom(username);
//           helper.setTo(email);
//           helper.setSubject("激活邮件");
//
//           Map<String,Object> model = new HashMap<>();
//           model.put();
//
//       } catch (MessagingException e) {
//           e.printStackTrace();
//       }
//   }
//}
