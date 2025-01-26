# Guida alla Configurazione di Elasticsearch

Questa guida ti aiuterà a configurare e avviare correttamente **Elasticsearch** per il progetto basato su **Spring Boot** che stai utilizzando.

## Prerequisiti

Prima di iniziare, assicurati di avere i seguenti requisiti:

- **Java 21+** installato sulla tua macchina.
- **Maven** per la gestione delle dipendenze.
- Un'istanza di **Elasticsearch** in esecuzione sulla tua macchina o nel cloud.

## 1. Installare Elasticsearch Localmente

### Passo 1: Scarica Elasticsearch
1. Vai alla pagina di download ufficiale di Elasticsearch: [Elasticsearch Download](https://www.elastic.co/downloads/elasticsearch).
2. Seleziona la versione di Elasticsearch compatibile con il tuo sistema operativo e scarica il pacchetto.

### Passo 2: Estrai e Avvia Elasticsearch
1. Estrai il pacchetto scaricato.
2. Vai nella cartella `bin` ed esegui il comando per avviare Elasticsearch:
    - Su **Linux/macOS**:
      ```bash
      ./elasticsearch
      ```
    - Su **Windows**:
      ```bash
      bin\elasticsearch.bat
      ```

Elasticsearch sarà avviato sulla porta predefinita `9200`. Puoi verificare che stia funzionando correttamente visitando l'URL `http://localhost:9200` nel tuo browser.

## 2. Usare Elasticsearch Cloud (Elastic Cloud)

Se non desideri installare Elasticsearch localmente, puoi utilizzare un'istanza cloud di Elasticsearch. Elastic offre un servizio gestito chiamato **Elastic Cloud**.

### Passo 1: Registrati su Elastic Cloud
1. Vai al sito di [Elastic Cloud](https://cloud.elastic.co).
2. Crea un account e avvia una nuova istanza di Elasticsearch.

### Passo 2: Ottieni l'Endpoint di Elasticsearch
1. Dopo aver creato il tuo cluster Elasticsearch, prendi nota dell'endpoint fornito da Elastic Cloud. Avrai qualcosa di simile a `https://your-cluster-name.us-east-1.aws.found.io:9243`.

### Passo 3: Configura il tuo Progetto
1. Apri il file `src/main/resources/application.properties` del tuo progetto.

2. Modifica la configurazione di Elasticsearch con l'endpoint del tuo cluster cloud:
   ```properties
   spring.data.elasticsearch.cluster-nodes=your-cluster-name.us-east-1.aws.found.io:9243
   spring.data.elasticsearch.cluster-name=your-cluster-name
   spring.data.elasticsearch.credentials.username=your-username
   spring.data.elasticsearch.credentials.password=your-password
   ```

## 3. Usare Elasticsearch con Docker
    Se preferisci non installare Elasticsearch direttamente sulla tua macchina, puoi eseguire Elasticsearch tramite Docker.
### Passo 1: Esegui Elasticsearch con Docker
1. Assicurati di avere Docker installato sulla tua macchina.
2. Esegui il seguente comando per avviare un'istanza di Elasticsearch in un container Docker:
    ```bash
    docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.15.1
    ```
    Questo comando avvierà un'istanza di Elasticsearch in un container Docker sulla tua macchina locale.
    Il container Docker esporrà Elasticsearch sulla porta 9200, proprio come l'installazione locale.

## 4. Configurazione di application.properties
1. Indipendentemente dal metodo scelto per avviare Elasticsearch, è necessario configurare correttamente il file application.properties nel tuo progetto.
       ```properties
       spring.data.elasticsearch.cluster-nodes=localhost:9200
       spring.data.elasticsearch.cluster-name=docker-cluster
       ```
       Se stai utilizzando Elastic Cloud, la configurazione sarà simile a questa:

        ```properties
       spring.data.elasticsearch.cluster-nodes=your-cluster-name.us-east-1.aws.found.io:9243
       spring.data.elasticsearch.cluster-name=your-cluster-name
       spring.data.elasticsearch.credentials.username=your-username
       spring.data.elasticsearch.credentials.password=your-password
       ```
## 5. Avviare l'Applicazione
### Passo 1: Esegui l'applicazione
1. Dopo aver configurato configurato Elasticsearch e quindi correttamente il file `application.properties`, puoi compilare e avviare l'applicazione Spring Boot.
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
   L'applicazione sarà disponibile su http://localhost:8080 (o su una porta diversa se configurata diversamente).
### Passo 1: Verifica il Funzionamento
    Puoi testare che Elasticsearch sia correttamente integrato visitando gli endpoint API descritti nel progetto. Usa strumenti come Postman o curl per interagire con le API.
1. Esegui una richiesta per aggiungere un documento:
    ```bash
    curl -X POST "http://localhost:8080/api/documents" -H "Content-Type: application/json" -d '{
      "id": "1",
      "title": "Nuovo Documento di esempio",
      "content": "Questo è un nuovo documento di esempio."
    }'
    ```
2. Esegui una richiesta di ricerca:
    ```bash
    curl -X GET "http://localhost:8080/api/search?q=Nuovo"
    ```
## 6. Eseguire i Test
1. Per verificare che l'integrazione con Elasticsearch funzioni correttamente, esegui i test dell'applicazione.
   Puoi eseguire i test unitari del progetto utilizzando Maven:
    ```bash
    mvn test
    ```
   I test dovrebbero passare senza errori se Elasticsearch è configurato correttamente e funzionante.