package com.gapht.restservice.answers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnswerTests {

	void contextLoads() {
	}

    @Test
    public void shouldSetUuid() throws Exception {
        Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        Answer answer = new Answer();

        System.out.println(UUID_REGEX.matcher(answer.getUuid().toString()));
        assertTrue(UUID_REGEX.matcher(answer.getUuid().toString()).matches());
    }
}
