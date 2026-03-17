package service;

import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.function.Supplier;

@ApplicationScoped
public class MyAugmentorSupplier implements Supplier<RetrievalAugmentor> {

    @Inject
    MyContentRetriever myRetriever; // O seu bean com o println

    @Override
    public RetrievalAugmentor get() {
        // Criamos um Augmentor padrão que usa o seu Retriever
        return DefaultRetrievalAugmentor.builder()
                .contentRetriever(myRetriever)
                .build();
    }
}
