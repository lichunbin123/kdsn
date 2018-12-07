package com.usping.kdsn.util.model;

import freemarker.template.Template;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailTemplate {

    private String sender;
    private String to;
    private String subject;
    private String content;

    private Template template;



}
