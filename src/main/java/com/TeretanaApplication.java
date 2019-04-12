package com;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJSONDoc
@EnableScheduling
public class TeretanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeretanaApplication.class, args);
	}
}
