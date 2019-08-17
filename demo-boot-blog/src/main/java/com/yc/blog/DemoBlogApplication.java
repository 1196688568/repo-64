package com.yc.blog;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
@MapperScan("com.yc")
public class DemoBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBlogApplication.class, args);
	}
	
	

}
