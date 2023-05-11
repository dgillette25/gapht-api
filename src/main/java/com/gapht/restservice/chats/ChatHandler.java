package com.gapht.restservice.chats;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ChatHandler {
    public Mono<ServerResponse> send(ServerRequest request) {
        System.out.println("Chat Handler");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(new Chat(1)));
    }
    
}
