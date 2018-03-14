package com.usping.kdsn.util.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 用于协助跨域的filter
 */
public class CorsFilterConfig extends CorsFilter {

    private static final Logger logger = Logger.getLogger(CorsFilterConfig.class.getName());
    
    public CorsFilterConfig() {
        configurationSource();
    }

    private static UrlBasedCorsConfigurationSource configurationSource() {
        logger.info("启动corsfilter");
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.setMaxAge(36000L);
        config.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"));
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
