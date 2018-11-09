package com.springboot;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
	     MultipartConfigFactory factory = new MultipartConfigFactory();
	     //允许上传的文件最大值
	     factory.setMaxFileSize("20MB"); //KB,MB
	     /// 设置总上传数据总大小
	     factory.setMaxRequestSize("1000MB");
	     return factory.createMultipartConfig();
	}
}
