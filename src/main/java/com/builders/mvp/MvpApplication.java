package com.builders.mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvpApplication.class, args);
	}

}
