package com.chensoul.caching.ttl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CachingTTLApplication {
	public static void main(String[] args) {
		SpringApplication.run(CachingTTLApplication.class, args);
	}
}
