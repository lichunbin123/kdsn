package com.usping.kdsn.util;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.mail.javamail.MimeMailMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * 发送邮件线程
 */
public class MailUtil implements Runnable{
    private String email;
//    private String code;
    public MailUtil(String email){
        this.email = email;
//        this.code = code;
    }
    @Override
    public void run() {
        String from = "1677254199@qq.com";//发件人邮箱
        String host = "smtp.qq.com";//指定发送邮件的主机

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host",host);
        properties.setProperty("mail.smtp.auth","true");//打开认证


            try {
                //通过SSL安全验证
                MailSSLSocketFactory sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                properties.put("mail.smtp.ssl.enable","true");
                properties.put("mail.smtp.ssl.socketFactory",sf);
                //获取session对象
                Session session = Session.getDefaultInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("1677254199@qq.com","ietrnncdgdmsbajc");

                    }
                });
                MimeMessage message = new MimeMessage(session);//创建邮件对象
                //设置发件人
                message.setFrom(new InternetAddress(from));
                //设置发件人
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                //设置邮件主题
                message.setSubject("账号激活");
                //设置邮件内容
                String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8081/register '>http://localhost:8081/register</href></h2></body></html>";
                message.setContent(content,"text/html;charset=UTF-8");
                //发送邮件
                Transport.send(message);
                System.out.println("邮件成功发送");
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
