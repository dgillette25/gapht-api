package com.gapht.restservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

@RestController
public class HomeController {
    private final AnswerRepository repository;

    HomeController(AnswerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String home() {
        return "Welcome to gapht!";
    }

    @CrossOrigin
	@PostMapping("/completions")
	public Answer completions(@RequestBody Answer newAnswer) {
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
