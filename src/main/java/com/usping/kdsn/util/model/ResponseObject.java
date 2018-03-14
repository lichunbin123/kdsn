package com.usping.kdsn.util.model;

/**
 * @author ning on 18-3-8.
 * @project kdsn
 */
public class ResponseObject {

    /**
     * most time to return status of operation should handle by http code
     * but sometimes with status
     */
    private boolean status;

    /**
     * whether failed or succeed, should return soe
     */
    private String message;

    /**
     * return data
     */
    private boolean data;

    /**
     * return length of data
     */
    private int length;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


}
