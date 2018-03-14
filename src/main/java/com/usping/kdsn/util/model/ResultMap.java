package com.usping.kdsn.util.model;

import java.util.HashMap;
import java.util.List;

/**
 * @author: stan
 * @date: 1/12/17
 * description:
 */
public class ResultMap<K> {

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
    private List<K> data;
    private Integer count;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<K> getData() {
        return data;
    }

    public void setData(List<K> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isEmpty() {
        return this.count == 0 && this.data.size() == 0;
    }
}
