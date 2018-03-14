package com.usping.kdsn.message.controller;

import com.usping.kdsn.bean.Message;
import com.usping.kdsn.message.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
}
