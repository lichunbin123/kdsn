package com.usping.kdsn.bean;

import lombok.*;
import org.springframework.context.annotation.Bean;

/**
 * @author ning on 18-4-5.
 * @project kdsn
 */

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private Integer noteId;

    private String newsId;

    private String noteTitle;

    private String noteType;

    private Integer noteScore;

    private Integer noteDate;

    private Integer userId;

    private String refUrl;

    private String noteContent;

    private Integer publicState;

}
