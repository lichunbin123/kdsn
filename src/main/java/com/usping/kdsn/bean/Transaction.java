package com.usping.kdsn.bean;

import com.usping.kdsn.util.model.BaseEntity;
import lombok.*;

import javax.persistence.Id;

/**
 * @author ning on 18-3-4.
 * @project kdsn
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction extends BaseEntity {

    @Id
    private Integer transactionId;

    private Integer customerId;

    private Integer vendorId;

    private Double productPrice;

    private Long purchaseQuantity;

    private Double calculatedPrice;

    private String productId;

    private Integer applicationStatus;

    private Integer transactionStatus;

    private Long applicationTime;

    private Long approvalTime;

    private Long completeTime;
}
