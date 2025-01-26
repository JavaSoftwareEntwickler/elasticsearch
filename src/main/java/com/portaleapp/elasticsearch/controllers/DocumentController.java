package com.portaleapp.elasticsearch.controllers;

import com.portaleapp.elasticsearch.models.Document;
import com.portaleapp.elasticsearch.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/create")
    public ResponseEntity<String> createDocument(@RequestBody Document document) {
        documentService.save(document);
        return ResponseEntity.ok("Documento salvato con successo");
    }


    // Ottenere un documento per ID
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable String id) {
        return documentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eseguire una ricerca
    @GetMapping("/search")
    public ResponseEntity<List<Document>> searchDocuments(@RequestParam("q") String query) {
        List<Document> results = documentService.searchByTitle(query);
        return ResponseEntity.ok(results);
    }

    // Aggiornare un documento
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDocument(@PathVariable String id, @RequestBody Document updatedDocument) {
        documentService.update(id, updatedDocument);
        return ResponseEntity.ok("Documento aggiornato con successo");
    }

    // Eliminare un documento
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable String id) {
        documentService.delete(id);
        return ResponseEntity.ok("Documento eliminato con successo");
    }
}
