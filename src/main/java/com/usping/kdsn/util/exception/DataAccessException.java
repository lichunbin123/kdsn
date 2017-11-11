package com.usping.kdsn.util.exception;

import java.util.logging.Logger;

public class DataAccessException extends Exception{
    private final static Logger logger = Logger.getLogger(DataAccessException.class.getName());

    @Override
    public void printStackTrace() {
        logger.info("产生了无权限访问的问题");
        super.printStackTrace();
    }
}
