package com.gapht.restservice.answers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.gapht.restservice.services.ai.ChatGPTFetcher;
import com.theokanning.openai.completion.CompletionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/questions")
public class AnswerController {
    private final AnswerRepository repository;
    Logger logger
        = LoggerFactory.getLogger(AnswerController.class);

    AnswerController(AnswerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index() {
        return "Will return an answer";
    }

    @CrossOrigin
	@PostMapping("/")
	public Answer completions(@RequestBody Answer newAnswer) {
        logger.info(newAnswer.getUuid().toString());
        newAnswer.getUuid();
        try {
            CompletionResult results = ChatGPTFetcher.fetchResult(newAnswer.getPrompt());
            results.getChoices().forEach(c -> newAnswer.setResult(c.getText()));
            repository.save(newAnswer);
        } catch (Exception e) {
            System.out.println(e);
        }

		return newAnswer;
	}
}
