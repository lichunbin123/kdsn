package com.usping.kdsn.mapper;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.bean.Transaction;

import java.util.List;

public interface MessageMapper {

    /**
     * delete instance by offered message id
     * @param messageId
     * @return
     */
    int deleteByPrimaryKey(Integer messageId);

    /**
     * insert selective
     * @param record
     * @return
     */
    boolean insertSelective(Message record);

    /**
     * select by message id
     * @param messageId
     * @return
     */
    Message selectByPrimaryKey(Integer messageId);

    /**
     * update by primary key selective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * select by senderId and receiverId
     * @param record
     * @return MessageList
     */
    List<Message> selectMessageBySenderAndReceiver(Message record);
}