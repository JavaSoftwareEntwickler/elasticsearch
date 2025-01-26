package com.portaleapp.elasticsearch.models;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@org.springframework.data.elasticsearch.annotations.Document(indexName = "documents")
public class Document {
    @Id
    private String id;
    private String title;
    private String content;

    // Getters e Setters
}