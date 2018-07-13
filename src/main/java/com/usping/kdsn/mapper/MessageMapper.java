package com.usping.kdsn.mapper;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.bean.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageMapper {

    /**
     * delete instance by offered message id
     * @param messageId
     * @return
     */
    int deleteByPrimaryKey(Integer messageId) throws DataAccessException;

    /**
     * insert selective
     * @param record
     * @return
     */
    void insertSelective(Message record) throws DataAccessException;

    /**
     * select by message id
     * @param messageId
     * @return
     */
    Message selectByPrimaryKey(Integer messageId) throws DataAccessException;

    /**
     * update by primary key selective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Message record) throws DataAccessException;

    /**
     * select by senderId and receiverId
     * @param record
     * @return MessageList
     */
    List<Message> selectMessageBySenderAndReceiver(Message record) throws DataAccessException;
}