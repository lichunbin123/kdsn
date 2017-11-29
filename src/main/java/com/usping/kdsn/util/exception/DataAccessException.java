package com.usping.kdsn.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataAccessException extends Exception{
    private final static Logger logger = LoggerFactory.getLogger(DataAccessException.class);
    
    @Override
    public void printStackTrace() {
        logger.info("产生了无权限访问的问题");
        super.printStackTrace();
    }
}
