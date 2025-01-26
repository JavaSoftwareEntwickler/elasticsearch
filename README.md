# Progetto di Integrazione con Elasticsearch

Questo è un progetto dimostrativo che mostra come integrare **Elasticsearch** in un'applicazione **Spring Boot** utilizzando **Spring Data Elasticsearch**. Il progetto include un'applicazione web che permette di interagire con Elasticsearch tramite API RESTful per eseguire operazioni di ricerca e gestione dei dati.

## Caratteristiche del progetto
- **Spring Boot** per la creazione di applicazioni web scalabili.
- Integrazione con **Elasticsearch** per il supporto alla ricerca full-text.
- API RESTful per interagire con il sistema di indicizzazione.
- Utilizzo di **Spring Data Elasticsearch** per facilitare l'integrazione tra Spring Boot ed Elasticsearch.
- **Spring Web** per la creazione di servizi web e API.
- Esempio di utilizzo di dati in formato **JSON** per l'interazione con le API.

## Tecnologie utilizzate
- **Java** 21+
- **Spring Boot** 3.4.2
- **Spring Data Elasticsearch**
- **Elasticsearch** (versione compatibile con Spring Boot)
- **Spring Web** per la creazione di servizi RESTful
- **Maven** per la gestione delle dipendenze

## Prerequisiti
- **Java 21+** installato sulla tua macchina.
- Un'istanza di **Elasticsearch** in esecuzione (puoi usare una versione locale o utilizzare un servizio cloud come Elastic Cloud).
- **Maven** per la gestione delle dipendenze (oppure utilizza un IDE che supporta Maven come IntelliJ IDEA o Eclipse).
- **Elasticsearch** deve essere configurato, vedi [ELASTICSEARCH_HELP.md](ELASTICSEARCH_HELP.md) per maggiori dettagli.
## Setup del progetto

1. **Clona il repository**:
   ```bash
   git clone git@github.com:JavaSoftwareEntwickler/elasticsearch.git
   cd elasticsearch
      ```
2. **Configura l'applicazione**:
    - Apri il file `application.properties` e configura le proprietà di connessione a Elasticsearch:
      ```properties
      spring.elasticsearch.uris=http://localhost:9200
      spring.elasticsearch.username=your_username
      spring.elasticsearch.password=your_password
      ```

3. **Compila e avvia l'applicazione**:
   ```bash
   mvn clean install
   mvn spring-boot:run
      ```
4. **Accedi all'applicazione**:
   - Apri il browser e vai all'indirizzo `http://localhost:8080` per accedere all'applicazione web.
   ```
## Esempi di utilizzo delle API

### Aggiungere un documento
    ```bash
        curl -X POST "http://localhost:8080/api/documents" -H "Content-Type: application/json" -d '{
          "id": "1",
          "title": "Documento di esempio",
          "content": "Questo è un documento di esempio."
        }'
    ```
### Eseguire una ricerca
    ```bash
        curl -X GET "http://localhost:8080/api/search?q=esempio"
    ```
### Ottenere un documento per ID
    ```bash
        curl -X GET "http://localhost:8080/api/documents/1"
    ```
### Aggiornare un documento
    ```bash
        curl -X PUT "http://localhost:8080/api/documents/1" -H "Content-Type: application/json" -d '{
          "title": "Documento di esempio aggiornato",
          "content": "Questo è un documento di esempio aggiornato."
        }'
    ```
### Eliminare un documento
    ```bash
        curl -X DELETE "http://localhost:8080/api/documents/1"
    ```
## Licenza
Questo progetto è distribuito con licenza **MIT**. Per ulteriori informazioni, vedere il file `LICENSE`.
