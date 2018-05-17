package com.usping.kdsn.message.controller;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.message.service.MessageService;
import com.usping.kdsn.util.model.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;


/**
 * design for chat
 *
 * @author ning on 18-3-6.
 * @project kdsn
 */
@RestController
@RequestMapping("/api/message/")
public class MessageController {
    private final static Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * for test connection
     * todo should remove once finished all the interface design
     */
    @Deprecated
    @CrossOrigin
    @GetMapping("test")
    @ResponseBody
    public ResponseEntity<?> testConnection() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * 消息接受，并存储
     * @param instance
     * @return 返回成功状态码
     */
    @CrossOrigin
    @PostMapping("sendMessage")
    @ResponseBody
    public ResponseEntity<?> sendMessage(@RequestBody Message instance) {
        // para debug, should delete soon
        System.out.println(instance.toString());
        try {
            messageService.saveInstance(instance);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("try to save into Message and failed due to " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     * 使用
     */
    @CrossOrigin
    @PostMapping("fetchMessage")
    public ResponseEntity<Map<String,Object>> fetchMessage(@RequestBody Message instance) {
        /*
         * 消息instance仅用于获取两个逻辑主键
         * 谁是聊天发起人，谁是被聊天人
         */
        Map<String, Object> resultMap = new WeakHashMap<>();

        logger.info("el instance get es " + instance.toString());
        try{
            List<Message> messageList = messageService.selectMessageBySenderAndReceiver(instance);
            resultMap.put("data", messageList);
            return new ResponseEntity<>(resultMap,HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
