# LogStream - Log Search and Indexing Engine

A distributed log search and indexing engine similar to Elasticsearch, built in Java.

## Features

- **Log Ingestion**: Accept logs via HTTP and UDP
- **Inverted Index**: Fast full-text search using inverted index data structure
- **Fuzzy Search**: Find logs even with typos (edit distance <= 2)
- **Horizontal Sharding**: Distribute data across multiple shards for scalability
- **Data Compression**: Gzip compression to minimize storage
- **Retention Policies**: Automatic archival and deletion of old logs
- **Query Interface**: REST API and CLI for searching logs

## Requirements

- Java 8 or higher
- Maven 3.6+ (for building)

## Project Structure

```
logstream/
├── src/
│   ├── main/java/com/logstream/
│   │   ├── model/          # Data models (LogEntry, Token, PostingList)
│   │   ├── index/          # Inverted index implementation
│   │   ├── ingestion/      # Log ingestion (HTTP/UDP servers)
│   │   ├── query/          # Query engine and search
│   │   ├── storage/        # Storage manager with compression
│   │   └── retention/      # Retention worker
│   └── test/java/com/logstream/  # Unit and property-based tests
├── pom.xml                 # Maven configuration
└── README.md
```

## Building

```bash
mvn clean install
```

## Running Tests

```bash
mvn test
```

## Architecture

LogStream follows a pipeline architecture:

1. **Ingestion Layer**: Receives logs via HTTP/UDP
2. **Indexing Layer**: Tokenizes text and builds inverted index
3. **Storage Layer**: Persists data with compression
4. **Query Engine**: Executes searches across shards
5. **Retention Worker**: Manages data lifecycle

## Implementation Status

- [x] Core data models (LogEntry, Token, PostingList, LogLevel)
- [ ] Tokenizer and normalizer
- [ ] Inverted index
- [ ] Log ingestion (HTTP/UDP)
- [ ] Query engine
- [ ] Fuzzy search
- [ ] Horizontal sharding
- [ ] Storage with compression
- [ ] Retention policies
- [ ] REST API and CLI

## License

MIT
