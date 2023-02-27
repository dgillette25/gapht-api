package com.gapht.restservice;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

public class ChatGPTFetcher {
    private static final String model = "text-davinci-003";
    private static final String token = "";

    static CompletionResult fetchResult(String prompt) {
        OpenAiService service = new OpenAiService(token);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model(model)
                .maxTokens(1000)
                .echo(true)
                .build();

        return service.createCompletion(completionRequest);
    }
} 