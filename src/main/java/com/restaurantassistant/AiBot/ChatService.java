package com.restaurantassistant.AiBot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt) {

        ChatClient client = ChatClient.builder(chatModel).build();

        var response = client.prompt()
                .user(prompt)
                .tools(new ToolService())
                .options(OpenAiChatOptions.builder()
                        .model("gpt-4o")
                        .temperature(0.0)
                        .toolChoice("auto")
                        .build())
                .call();

        return response.content();
    }

        @Tool(description = "Get the current date and time in the user's timezone")
        String getCurrentDateTime() {
            return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
        }




}
