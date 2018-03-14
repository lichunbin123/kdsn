package com.usping.kdsn.bean;

import com.usping.kdsn.util.model.BaseEntity;
import org.springframework.data.annotation.Transient;

/**
 * @author ning on 18-3-6.
 * @project kdsn
 */
public class Message extends BaseEntity {

    @Transient
    public static final Integer STATUS_SEND_FAILED = -1;

    @Transient
    public static final Integer STATUS_SENT = 0;

    @Transient
    public static final Integer STATUS_UNREAD = 2;

    @Transient
    public static final Integer STATUS_READ = 3;


    /**
     * messageId
     * use for describe unique message
     */
    private Integer messageId;

    /**
     * user id de sender
     */
    private Integer senderId;

    /**
     * user id de receiver
     */
    private Integer receiverId;

    /**
     * content de the message
     */
    private String messageContent;

    /**
     * the status of post
     */
    private Integer deliveryStatus;

    /**
     * time for message sent
     */
    private Long sendTime;

    /**
     * username of sender
     */
    private String senderUsername;

    /**
     * username of receiver
     */
    private String receiverUsername;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", messageContent='" + messageContent + '\'' +
                ", deliveryStatus=" + deliveryStatus +
                ", sendTime=" + sendTime +
                ", senderUsername='" + senderUsername + '\'' +
                ", receiverUsername='" + receiverUsername + '\'' +
                '}';
    }
}
