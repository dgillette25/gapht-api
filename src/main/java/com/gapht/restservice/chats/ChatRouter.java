package com.gapht.restservice.chats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.http.MediaType;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class ChatRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ChatHandler chatHandler) {
      System.out.println("Chat router");
  
      return RouterFunctions
        .route(GET("/chat").and(accept(MediaType.APPLICATION_JSON)), chatHandler::send);
    }
    
}
