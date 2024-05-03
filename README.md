# Spring AI with local LLAMA3

## Overview
This demo demonstrates the integration of a local LLama3 model for handling JSON responses within the Spring AI framework, positioning it as a 'business logic' executor. This provides a starting point specifically tailored for simple artificial intelligence workflows, using Java and Spring AI.


## Prerequisites
- Java 17/21
- Maven 3.3+ for building and managing the project

## Technologies
- **Spring Boot**: Simplifies the bootstrapping and development of new Spring Framework applications.
- **Spring AI**: Provides AI capabilities integrated seamlessly with Spring applications. In this project, we use local LLM `spring-ai-ollama-spring-boot-starter` for integrating the LLama3 llm.
- **Ollama**: a tool to run Large Language Models locally for manage safe private data.

## Getting Started

1. **Install and run LLama3 with Ollama**:
    ```bash
    ollama run llama3 

2. **Clone the Repository**:
   ```bash
   git clone https://your-repository-url-here
   cd search-book-with-llm

3. **Build the Application**:
   ```bash
   mvn clean install

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
