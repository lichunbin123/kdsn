package com.usping.kdsn.util.config;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by stan on 17-7-2.
 */
@Configuration
public class DefaultViewConfig extends WebMvcConfigurerAdapter {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DefaultViewConfig.class);

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
        registry.addMapping("/").allowedOrigins("*");
    }
}
