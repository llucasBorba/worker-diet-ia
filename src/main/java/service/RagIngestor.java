package service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.nio.file.Paths;
import java.util.List;

@ApplicationScoped
public class RagIngestor {

    @Inject
    EmbeddingStore<TextSegment> store; // A "Gaveta"
    @Inject
    EmbeddingModel model;             // O "Tradutor para números" (Ollama)

    public void onStart(@Observes StartupEvent ev) {
        // A. LOAD (Carregamento)
        // Varre a pasta 'rag' e transforma arquivos em objetos 'Document'.
        var dir = Paths.get("src/main/resources/rag");
        List<Document> documents = FileSystemDocumentLoader.loadDocuments(dir, new ApacheTikaDocumentParser());

        // B. SPLIT (Fragmentação)
        // Divide textos longos em pedaços de 500 caracteres com sobreposição de 50.
        // Isso garante que a IA não receba informação cortada ou grande demais.
        var splitter = DocumentSplitters.recursive(500, 50);

        // C. EMBED & STORE (Vetorização e Carga)
        // Aqui o Ingestor envia cada pedaço para o Ollama (all-minilm),
        // recebe o vetor (lista de números) e guarda no Infinispan.
        EmbeddingStoreIngestor.builder()
                .documentSplitter(splitter)
                .embeddingStore(store)
                .embeddingModel(model)
                .build()
                .ingest(documents);

        System.out.println("✅ Conhecimento carregado!");
    }
}

