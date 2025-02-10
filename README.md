<h1 align="center"> Smart Envios 🚚 </h1>

## Descrição do Projeto

<p>
    Esse projeto é uma rotina na qual está programada para executar a cada 60 segundos.
    A rotina tem como objetivo buscar os dados de envios de uma API e enviar para um Kafka.
</p>

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Kafka
- Docker
- Docker Compose
- Gradle
  
### Pré-requisitos

- Docker
- Kafka
- Mongo

## Como executar o projeto

```bash
# Clone este repositório
$ git clone https://github.com/itmoura/smart-envios-scheduler.git

# Acesse a pasta do projeto no terminal
$ cd smart-envios-scheduler

# Execute o comando para subir o Kafka e o Mongo
$ docker-compose up -d --build

# Execute o comando para subir o projeto (ou execute o projeto na sua IDE de preferência)
$ ./gradlew bootRun
```
