package com.usping.kdsn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
@ServletComponentScan("com.usping.kdsn.util.filter")
@MapperScan({"com.usping.kdsn.mapper","com.usping.kdsn.auth.mapper"})
public class KdsnApplication extends SpringBootServletInitializer{


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KdsnApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(KdsnApplication.class, args);
	}
}
