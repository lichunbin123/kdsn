package com.usping.kdsn.service.serviceImpl;

import com.usping.kdsn.bean.Source;
import com.usping.kdsn.dao.SourceDao;
import com.usping.kdsn.service.SourceService;
import com.usping.kdsn.util.model.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class SourceServiceImpl implements SourceService {

    private final Logger logger = LoggerFactory.getLogger(SourceServiceImpl.class);

    @Autowired
    private  SourceDao sourceDao;


    @Override
    public ResponseMessage<Source> insert(Source source) {
        HttpStatus status ;
        String messageContent;

        try{
            if (!sourceDao.insertSelective(source)) {
                logger.info("插入表失败");
                messageContent = "您的提交异常,请检查您的输入后重新提交!";
                status = HttpStatus.CONFLICT;
            }
            messageContent = "操作成功!";
            status = HttpStatus.OK;

        } catch (DataAccessException e) {
            logger.info("数据异常, 插入表" + e.toString());
            messageContent = "您的提交异常,请检查您的输入后重新提交!";
            status = HttpStatus.CONFLICT;
        }
        return ResponseMessage.<Source>builder().httpStatus(status).messageContent(messageContent).build();
    }
}
