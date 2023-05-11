package com.gapht.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import com.gapht.restservice.chats.ChatClient;
import com.gapht.restservice.services.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class RestServiceApplication {
	

	public static void main(String[] args) {
        System.out.println("Main chat");
		ConfigurableApplicationContext context = SpringApplication.run(RestServiceApplication.class, args);
		System.out.println("Hit here");
		ChatClient chatClient = context.getBean(ChatClient.class);
		// We need to block for the content here or the JVM might exit before the message is logged
		System.out.println(">> message = " + chatClient.getMessage().block());
	}

}
