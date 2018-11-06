package com.usping.kdsn.message.controller;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.message.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    private final static Logger logger = LoggerFactory.getLogger(GreetingController.class);

    private final MessageService messageService;

    private final
    SimpMessagingTemplate messagingTemplate;

    @Autowired
    public GreetingController(SimpMessagingTemplate messagingTemplate, MessageService messageService) {
        logger.info("Hola Mundo, socket service started");
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * 通过接受的信息参数
     * @param message
     * @return
     */
    @CrossOrigin
    @MessageMapping("/sendMessage")
    @SendTo("/queue/chat")
    public Message sendMessage (@RequestParam Message message) {

        logger.info("接收到了信息" + message.getSenderAccount());
        try {
            messageService.saveInstance(message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存信息失败，原因为： " + e.getMessage());
        }
        //        String destUser = message.getReceiverUsername();
        return message;
    }

    @CrossOrigin
    @MessageMapping("/fetchMessage")
    @SendTo("/queue/chat")
    public Map<String, Object> fetchMessage(@RequestParam  Message message) {
        HashMap<String, Object> resultMap = new HashMap<>(4);

        List<Message> messageList = null;
        try {
            messageList = messageService.selectMessageBySenderAndReceiver(message);
            logger.info("查询成功，返回" + messageList.size() + "条数据");
            resultMap.put("messageList", messageList);
            resultMap.put("len", messageList.size());
        }
        catch (DataAccessException e){
            logger.warn("数据访问异常");
            resultMap.put("len", 0);
        }

        resultMap.put("userId", message.getReceiverAccount());

        return resultMap;

//        return messageList;
    }
}
