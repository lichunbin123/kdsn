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
public class MessageServiceImpl implements MessageService{
    private final MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }


    @Override
    public boolean saveInstance(Message instance) {
        return messageMapper.insertSelective(instance);
    }

    @Override
    public List<Message> selectMessageBySenderAndReceiver(Message instance) {
        return messageMapper.selectMessageBySenderAndReceiver(instance);
    }
}
