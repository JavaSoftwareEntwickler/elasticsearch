package com.portaleapp.elasticsearch.repositories;

import com.portaleapp.elasticsearch.models.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DocumentRepository extends ElasticsearchRepository<Document, String> {
    List<Document> findByTitleContaining(String query);
}
