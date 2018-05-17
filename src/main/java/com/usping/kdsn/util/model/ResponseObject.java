package com.usping.kdsn.util.model;

import lombok.*;

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
public class ResponseObject<T> {

    /**
     * 告知查询成功与否
     */
    private boolean success;

    /**
     * 如失败，则应告知失败原因
     */
    private String message;

    /**
     * T泛型返回数据
     */
    private List<T> data;

    /**
     * 数据数量
     */
    private Integer count;

}
