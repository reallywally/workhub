package com.wally.workhub;

import com.wally.workhub.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class WorkhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkhubApplication.class, args);
	}

}
