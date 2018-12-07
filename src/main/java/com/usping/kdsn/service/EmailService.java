package com.usping.kdsn.service;

import com.usping.kdsn.util.model.EmailMessage;
import com.usping.kdsn.util.model.EmailTemplate;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;

public interface EmailService {

     MimeMessageHelper packageEmail(EmailTemplate template, EmailMessage emailMessage) throws MessagingException;

     void sendEmail(String mail);
}
