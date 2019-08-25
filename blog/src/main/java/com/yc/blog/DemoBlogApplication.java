package com.yc.blog;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.blog.web.LoginInterceptor;



@SpringBootApplication
@Controller
@MapperScan("com.yc")
public class DemoBlogApplication implements WebMvcConfigurer{
	
	public static void main(String[] args) {
		SpringApplication.run(DemoBlogApplication.class, args);
	}

	/**
	 * 注册拦截器，当容器启动时，该方法会被调用，那么注册拦截就会被加载到容器中
	 */
	@Override
	public void addInterceptors( InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/toedit")
		.addPathPatterns("/comment");
	}

}
