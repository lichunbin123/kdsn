package com.usping.kdsn.bean;

import org.springframework.beans.factory.annotation.Value;

public class Email {
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.properties.mail.smtp.host}")
    private  String propshost;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private  String propsauth;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPropshost() {
        return propshost;
    }

    public void setPropshost(String propshost) {
        this.propshost = propshost;
    }

    public String getPropsauth() {
        return propsauth;
    }

    public void setPropsauth(String propsauth) {
        this.propsauth = propsauth;
    }
}
