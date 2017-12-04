package com.usping.kdsn.util.model;

import java.util.HashMap;
import java.util.List;

/**
 * @author: stan
 * @date: 1/12/17
 * description:
 */
public class ResultMap extends HashMap<String, Object> {

    public ResultMap() {
    }

    /**
     * 设置列表
     * @param data
     * @return
     */
    public ResultMap setData(List data) {
        this.put("data", data);
        return this;
    }

    /**
     * 设置参数
     * @param total
     * @return
     */
    public ResultMap setTotal(int total) {
        this.put("total", total);
        return this;
    }

    /**
     * 判断该resultMap的数据是否为空
     * @return
     */
    public boolean isEmpty () {
        try {
            Object o = this.get("data");
            return ((List)o).isEmpty();
        }catch (Exception e){
            return false;
        }
    }
}
