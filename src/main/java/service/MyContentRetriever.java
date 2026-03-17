package service;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.rag.query.Query;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.data.segment.TextSegment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
@Named("my-retriever")
public class MyContentRetriever implements ContentRetriever {


    private final EmbeddingStoreContentRetriever retriever;

    @Inject
    public MyContentRetriever(EmbeddingStore<TextSegment> store, EmbeddingModel model) {
        // Configuramos o buscador para trazer os 2 pedaços mais relevantes
        this.retriever = EmbeddingStoreContentRetriever.builder()
                .embeddingStore(store)
                .embeddingModel(model)
                .maxResults(3)
                .minScore(0.5) // Só traz se tiver pelo menos 50% de similaridade
                .build();
    }

    @Override
    public List<Content> retrieve(Query query) {
        System.out.println("🔍 RAG: Buscando contexto para a pergunta: " + query.text());
        return retriever.retrieve(query);
    }
}