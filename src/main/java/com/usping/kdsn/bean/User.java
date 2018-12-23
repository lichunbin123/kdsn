package com.usping.kdsn.bean;

import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 6512710388246191617L;

    private Integer userId;

    private String userAccount;

    private String userNickname;

    private String userEmail;

    private String userPhone;

    private String userIndustry;

    private String userGenre;

    private Integer userRole;

    private String userLocation;

    private String userSchool;

    private String userPassword;

    private String workExperience;

    private String projectExperience;

    private String authorizationToken;

    private Integer code;
}
