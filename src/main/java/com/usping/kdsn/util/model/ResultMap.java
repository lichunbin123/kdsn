package com.usping.kdsn.util.model;

import lombok.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author: stan
 * @date: 1/12/17
 * description:
 */

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ResultMap {

//    public ResultMap() {
//    }
//
//    /**
//     * 设置列表
//     * @param data
//     * @return
//     */
//    public ResultMap setData(List data) {
//        this.put("data", data);
//        return this;
//    }
//
//    /**
//     * 设置参数
//     * @param total
//     * @return
//     */
//    public ResultMap setTotal(int total) {
//        this.put("total", total);
//        return this;
//    }
//
//    public ResultMap setSuccess() {
//        this.put("success", !this.isEmpty());
//        return this;
//    }
//
//    /**
//     * 设置成功状态
//     * @param success
//     * @return
//     */
//    public ResultMap setSuccess(boolean success){
//        this.put("success", success);
//        return this;
//    }
//
//    /**
//     * 判断该resultMap的数据是否为空
//     * @return
//     */
//    @Override
//    public boolean isEmpty () {
//        try {
//            Object o = this.get("data");
//            return ((List)o).isEmpty();
//        }catch (Exception e){
//            return false;
//        }
//    }
    private boolean success;
    private List data;
    private Integer count;
    private boolean empty;



}
