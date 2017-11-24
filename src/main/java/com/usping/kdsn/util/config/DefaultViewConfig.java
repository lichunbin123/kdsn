package com.usping.kdsn.util.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.logging.Logger;

/**
 * Created by stan on 17-7-2.
 */
@Configuration
public class DefaultViewConfig extends WebMvcConfigurerAdapter {

    private final Logger logger = Logger.getLogger(DefaultViewConfig.class.getName());


    @Override
    public void
    addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index/index.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//
//        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("匹配/*跨域");
        registry.addMapping("/*").allowedOrigins("*");
    }
}
