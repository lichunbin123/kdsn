package com.usping.kdsn.message.service;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ning on 18-3-6.
 * @project kdsn
 */
@Component
public class MessageService{
    private final MessageMapper messageMapper;

    @Autowired
    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }


    public boolean saveInstance(Message instance) {
        return messageMapper.insertSelective(instance);
    }

    public List<Message> selectMessageBySenderAndReceiver(Message instance) {
        return messageMapper.selectMessageBySenderAndReceiver(instance);
    }
}
