package com.usping.kdsn.service.serviceImpl;


import com.usping.kdsn.bean.Message;
import com.usping.kdsn.bean.User;
import com.usping.kdsn.dao.AuthDao;
import com.usping.kdsn.util.model.EmailMessage;
import com.usping.kdsn.util.model.EmailTemplate;
import com.usping.kdsn.service.EmailService;
import com.usping.kdsn.util.model.ResponseMessage;
import com.usping.kdsn.util.tools.TokenTool;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class EmailServiceImpl implements EmailService {

    int code ;

    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class.getName());

    private final AuthDao authDao;
    @Autowired
    private JavaMailSenderImpl emailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfig;

    public EmailServiceImpl(AuthDao authDao) {
        this.authDao = authDao;
    }


    @Override
    public MimeMessageHelper packageEmail(EmailTemplate emailTemplate, EmailMessage emailMessage) throws javax.mail.MessagingException {

        MimeMessageHelper helper = new MimeMessageHelper(emailMessage.getMessage(),
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

//        Map<String, Object> model = new HashMap<>();
//        model.put("username", "didi");

        Template template = null;

        try {
            template = freeMarkerConfig.getConfiguration().getTemplate("email.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, null);
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
    public MimeMessageHelper packageCode(EmailTemplate template, EmailMessage emailMessage) throws MessagingException {

        MimeMessageHelper helper = new MimeMessageHelper(emailMessage.getMessage(),
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        try {
            code =(int) (Math.random() * 9000 + 1000);
            helper.setFrom(template.getSender());
            helper.setTo(template.getTo());
            helper.setSubject(template.getSubject());
            helper.setText(String.valueOf(code));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return helper;
    }

    @Override
    public void sendEmail(String mail) {
        EmailTemplate emailTemplate = EmailTemplate.builder().sender("1677254199@qq.com").to(mail).subject("verify email").build();
        EmailMessage emailMessage = EmailMessage.builder().message(emailSender.createMimeMessage()).build();
        try {
            packageEmail(emailTemplate, emailMessage);
            emailSender.send(emailMessage.getMessage());
            logger.info("the email were just send to" + mail + "succeed!");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void sendCodeEmail(String mail) {
        EmailTemplate emailTemplate = EmailTemplate.builder().sender("1677254199@qq.com").to(mail).subject("验证码").build();
        EmailMessage emailMessage = EmailMessage.builder().message(emailSender.createMimeMessage()).build();
        try {
            packageCode(emailTemplate, emailMessage);
            emailSender.send(emailMessage.getMessage());
            logger.info("the code were just send to" + mail + "succeed!");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseMessage sendCode(User sendCodeUser) {
        if (sendCodeUser.getUserAccount().trim().length() == 0
                || sendCodeUser.getUserAccount() == null
                || sendCodeUser.getUserEmail().trim().length() == 0
                || sendCodeUser.getUserEmail() == null) {
            logger.info("禁止非法验证");
            return ResponseMessage.builder().successStatus(false)
                    .httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("返回信息有误").build();
        }
        logger.info("重置密码的信息为" + sendCodeUser.toString());
        try {
            List<User> userList = authDao.selectByAccount(sendCodeUser.getUserAccount());
            if (userList == null || userList.size() != 1) {
                logger.info("未查询到信息");
                return ResponseMessage.builder().successStatus(false).httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("无此帐号").build();
            }

            User dbUser = userList.get(0);

            if (dbUser.getUserEmail().equals(sendCodeUser.getUserEmail())) {

                sendCodeEmail(sendCodeUser.getUserEmail());

                String token = TokenTool.generateToken(sendCodeUser.getUserAccount());
                List<User> dataList = new ArrayList<>();
                dbUser.setAuthorizationToken(token);
                dataList.add(dbUser);
                return ResponseMessage.<User>builder().successStatus(true).responseData(dataList)
                        .messageContent("邮箱正确，允许重置密码").httpStatus(HttpStatus.OK).build();
            }
            return ResponseMessage.builder().successStatus(false).httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("登录信息有误").build();
        } catch (DataAccessException e) {
            logger.info("重置异常");
            return ResponseMessage.builder().successStatus(false).httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("网络异常,请联系管理员").build();
        }
    }

    @Override
    public ResponseMessage resetPassword(User resetUser) {
        if (resetUser.getUserAccount().trim().length() == 0
                || resetUser.getUserAccount() == null
                || resetUser.getUserEmail().trim().length() == 0
                || resetUser.getUserEmail() == null) {
            logger.info("禁止非法");
            return ResponseMessage.builder().successStatus(false)
                    .httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("返回信息有误").build();
        }
        logger.info("重置密码的信息为" + resetUser.toString());
        try {
            List<User> userList = authDao.selectByAccount(resetUser.getUserAccount());
            if (userList == null || userList.size() != 1) {
                logger.info("未查询到信息");
                return ResponseMessage.builder().successStatus(false).httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("无此帐号").build();
            }

            User dbUser = userList.get(0);
            logger.info("code is == "+code);
            if (dbUser.getUserEmail().equals(resetUser.getUserEmail())&&(resetUser.getCode()).equals(code)) {
                try {
                    logger.info(""+resetUser.getUserPassword()+""+resetUser.getUserAccount());
                    authDao.update(resetUser.getUserPassword(),resetUser.getUserAccount());
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                logger.info("after reset password" + resetUser.toString());
                String token = TokenTool.generateToken(resetUser.getUserAccount());
                List<User> dataList = new ArrayList<>();
                dbUser.setAuthorizationToken(token);
                dataList.add(dbUser);
                return ResponseMessage.<User>builder().successStatus(true).responseData(dataList)
                        .messageContent("邮箱正确，允许重置密码").httpStatus(HttpStatus.OK).build();
            }
            return ResponseMessage.builder().successStatus(false).httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("登录信息有误").build();
        } catch (DataAccessException e) {
            logger.info("重置异常");
            return ResponseMessage.builder().successStatus(false).httpStatus(HttpStatus.NOT_ACCEPTABLE).messageContent("网络异常,请联系管理员").build();
        }

    }
}
