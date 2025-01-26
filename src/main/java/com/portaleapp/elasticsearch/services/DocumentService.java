package com.portaleapp.elasticsearch.services;

import com.portaleapp.elasticsearch.models.Document;
import com.portaleapp.elasticsearch.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public void save(Document document) {
        documentRepository.save(document);
    }


    public Optional<Document> findById(String id) {
        return documentRepository.findById(id);
    }

    public List<Document> searchByTitle(String query) {
        return documentRepository.findByTitleContaining(query);
    }

    public void update(String id, Document updatedDocument) {
        Optional<Document> existingDocument = documentRepository.findById(id);
        if (existingDocument.isPresent()) {
            Document document = existingDocument.get();
            document.setTitle(updatedDocument.getTitle());
            document.setContent(updatedDocument.getContent());
            documentRepository.save(document);
        }
    }

    public void delete(String id) {
        documentRepository.deleteById(id);
    }
}
