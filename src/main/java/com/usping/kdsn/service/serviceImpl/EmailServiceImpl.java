package com.usping.kdsn.service.serviceImpl;


import com.usping.kdsn.util.model.EmailMessage;
import com.usping.kdsn.util.model.EmailTemplate;
import com.usping.kdsn.service.EmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@Component
public class EmailServiceImpl implements EmailService {
    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class.getName());
    @Autowired
    private JavaMailSenderImpl emailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfig;
    public EmailServiceImpl(){

    }



    @Override
    public MimeMessageHelper packageEmail(EmailTemplate emailTemplate, EmailMessage emailMessage) throws javax.mail.MessagingException{

        MimeMessageHelper helper = new MimeMessageHelper(emailMessage.getMessage(),
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

//        Map<String, Object> model = new HashMap<>();
//        model.put("username", "didi");

        Template template = null;

        try {
            template = freeMarkerConfig.getConfiguration().getTemplate("email.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,null);
            helper.setFrom(emailTemplate.getSender());
            helper.setTo(emailTemplate.getTo());
            helper.setSubject(emailTemplate.getSubject());
            helper.setText(html, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return helper;
    }

    @Override
    public void sendEmail(String mail) {
        EmailTemplate emailTemplate = EmailTemplate.builder().content("nihao").sender("1677254199@qq.com").to(mail).subject("verify email").build();
        EmailMessage emailMessage = EmailMessage.builder().message(emailSender.createMimeMessage()).build();
        try {
            packageEmail(emailTemplate,emailMessage);
            emailSender.send(emailMessage.getMessage());
            logger.info("the email were just send to"+mail+"succeed!");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }

}
