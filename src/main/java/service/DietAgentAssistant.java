package service;

import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.inject.Named;

@RegisterAiService(retrievalAugmentor = MyAugmentorSupplier.class)
public interface DietAgentAssistant {

    @SystemMessage("""
        Você é um assistente virtual prestativo.
        Ao responder, use APENAS as informações fornecidas no contexto.
        Se a informação não estiver no contexto, diga que não achou no contexto e forneça a resposta.
        """)
    String chat(@UserMessage String userMessage);

    //String expert(@MemoryId String memory, @UserMessage String userMessage);
}
