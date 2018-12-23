package com.usping.kdsn.service;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.util.model.EmailMessage;
import com.usping.kdsn.util.model.EmailTemplate;
import com.usping.kdsn.util.model.ResponseMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;

public interface EmailService {

     MimeMessageHelper packageEmail(EmailTemplate template, EmailMessage emailMessage) throws MessagingException;

     MimeMessageHelper packageCode(EmailTemplate template,EmailMessage emailMessage) throws MessagingException;

     void sendEmail(String mail);

     void sendCodeEmail(String mail);

     ResponseMessage sendCode(User sendCodeUser);

     ResponseMessage resetPassword(User resetUser);
}
