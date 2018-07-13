package com.usping.kdsn.bean;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithBLOBs extends User {
    private static final long serialVersionUID = -1243088714039114790L;
    private String workExperience;

    private String projectExperience;

}