package com.bca.omniservice.rest.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@ComponentScan({"com.bca.omniservice.rest.*"})
@SpringBootApplication
public class SimpleRestJPAApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleRestJPAApplication.class, args);
	}

}
