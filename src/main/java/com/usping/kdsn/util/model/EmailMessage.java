package com.usping.kdsn.util.model;

import lombok.*;

import javax.mail.internet.MimeMessage;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailMessage {
    MimeMessage message;

    public MimeMessage getMessage() {
        return message;
    }

    public void setMessage(MimeMessage message) {
        this.message = message;
    }
}
