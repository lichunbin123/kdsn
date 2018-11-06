package com.usping.kdsn.bean;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Source {
    private int id;
    private int applyUser;
    private String siteName;
    private String siteUrl;
    private int applyStatus;
    private int applyHandler;
}
