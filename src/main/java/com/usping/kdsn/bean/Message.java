package com.usping.kdsn.bean;

import com.usping.kdsn.util.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ning on 18-3-6.
 * @project kdsn
 */
@Getter
@Setter
@ToString
public class Message {

    public static final Integer STATUS_SEND_FAILED = -1;

    public static final Integer STATUS_SENT = 0;

    public static final Integer STATUS_UNREAD = 2;

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
    private String senderAccount;

    /**
     * username of receiver
     */
    private String receiverAccount;

}
