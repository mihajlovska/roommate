package com.roommate;

import com.roommate.api.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class RoommateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoommateApplication.class, args);
	}

}
