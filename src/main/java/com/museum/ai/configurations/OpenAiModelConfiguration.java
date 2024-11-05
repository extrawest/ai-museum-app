package com.museum.ai.configurations;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class OpenAiModelConfiguration {
    @Value("${ai.base-url}")
    private String baseUrl;
    @Value("${ai.api-key}")
    private String apiKey;
    @Value("${ai.model-name}")
    private String modelName;

    @Bean
    public OpenAiChatModel newLLM() {
        return OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .timeout(Duration.ofMinutes(2))
                .logRequests(true)
                .logResponses(true)
                .maxRetries(1)
                .temperature(0.0)
                .maxTokens(2000)
                .build();

    }
}
