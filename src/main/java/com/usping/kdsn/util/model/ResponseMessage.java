package com.usping.kdsn.util.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author ning on 18-3-8.
 * @project kdsn
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseMessage {

    /**
     * 告知查询成功与否
     */
    private Boolean success;

    /**
     * 如失败，则告知失败原因
     */
    private String message;

    /*
     * 同时返回http状态码
     */
    private HttpStatus code;

    /*
     * 如有数据，返回数据
     */
    private List data;
}
