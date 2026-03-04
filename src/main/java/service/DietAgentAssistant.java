package service;

import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface DietAgentAssistant {

    String chat (String userMessage);
}
