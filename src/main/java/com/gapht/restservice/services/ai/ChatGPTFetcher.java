package com.gapht.restservice.services.ai;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

public class ChatGPTFetcher {
    private static final String model = "gpt-3.5-turbo";
    private static final String token = "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";

    public static CompletionResult fetchResult(String prompt) {
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