package com.yc.blog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * 
 * ****/

@SpringBootApplication
@Controller
public class DemoBoot64Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoBoot64Application.class, args);
	}
	@GetMapping("hello")
	public String hello() {
		return "hello world!";
	}
	
}
