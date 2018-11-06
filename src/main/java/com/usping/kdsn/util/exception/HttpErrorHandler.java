package com.usping.kdsn.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HttpErrorHandler implements ErrorController {

    private final Logger logger = LoggerFactory.getLogger(HttpErrorHandler.class);

    private final static String ERROR_PATH = "/error";

    /**
     * Support HTML
     *
     * @param request request source
     * @return 404
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorHtml(HttpServletRequest request){
        logger.info("404 Got");
        return "404";
    }

    /**
     * return JSON/XML format error
     *
     * @param request request from
     * @return 404
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public String error(HttpServletRequest request) {
        logger.info("404 Got");
        return "404";
    }

    /**
     * Return the path of error page
     *
     * @return the error path
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
