package com.usping.kdsn.bean;

import com.usping.kdsn.util.model.BaseEntity;

/**
 * @author ning on 18-3-4.
 * @project kdsn
 */
public class Transaction extends BaseEntity{
    /**
     * transaction id
     * with 11 digits
     */
    private Integer transactionId;

    /**
     * customer id
     * the id of customer, with 11 digits
     * refer to userId in user.userId
     */
    private Integer customerId;

    /**
     * vendor_id
     * the id of vendor, with 11 digits
     * refer to userId in user.userId
     */
    private Integer vendorId;

    /**
     *
     */
    private Double product_price;

    private Long purchase_quantity;

    private Double calculated_price;

    /**
     * product_id
     * the id of product, type is String which
     * refer to product._source.id in Elasticsearch data
     */
    private String product_id;

    private Integer application_status;

    private Integer transaction_status;

    private Long application_time;

    private Long approval_time;

    /**
     * completion_time
     * time of the transaction end
     */
    private Long completion_time;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Long getPurchase_quantity() {
        return purchase_quantity;
    }

    public void setPurchase_quantity(Long purchase_quantity) {
        this.purchase_quantity = purchase_quantity;
    }

    public Double getCalculated_price() {
        return calculated_price;
    }

    public void setCalculated_price(Double calculated_price) {
        this.calculated_price = calculated_price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Integer getApplication_status() {
        return application_status;
    }

    public void setApplication_status(Integer application_status) {
        this.application_status = application_status;
    }

    public Integer getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(Integer transaction_status) {
        this.transaction_status = transaction_status;
    }

    public Long getApplication_time() {
        return application_time;
    }

    public void setApplication_time(Long application_time) {
        this.application_time = application_time;
    }

    public Long getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(Long approval_time) {
        this.approval_time = approval_time;
    }

    public Long getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Long completion_time) {
        this.completion_time = completion_time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", customerId=" + customerId +
                ", vendorId=" + vendorId +
                ", product_price=" + product_price +
                ", purchase_quantity=" + purchase_quantity +
                ", calculated_price=" + calculated_price +
                ", product_id='" + product_id + '\'' +
                ", application_status=" + application_status +
                ", transaction_status=" + transaction_status +
                ", application_time=" + application_time +
                ", approval_time=" + approval_time +
                ", completion_time=" + completion_time +
                '}';
    }
}
