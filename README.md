# registry-rest-api

[![GitHub issues](https://img.shields.io/github/issues/DanPascoalato/registry-rest-api)](https://github.com/DanPascoalato/registry-rest-api/issues)

Registry Rest API é um projeto desenvolvido para atender o desafio do processo seletivo da Docket, utilizando Java 11 e 
Spring para a criação de um sistema de cartórios

##Pré-requisitos
- JDK 11 
- Spring Framework (Spring Boot, Spring MVC, Spring Data JPA)
- Gradle

##Sobre o projeto

###Packages
- Controller: Controllers e endpoints da Spring
- Model: Classes de modelo 
- Service: Camada de serviço para pegar a lista de certidões da REST API da Docket
- Repository: Trata as transações do banco de dados

###Executando

Caso queira executar por linha de comando basta executar os seguintes comandos dependendo do seu sistema.

**Linux ou Mac**
```
./gradlew build
cd ${PROJECT_ROOT_DIR}/build/libs/regestry-rest-api-0.1-SNAPSHOT.jar
java -jar regestry-rest-api-0.1-SNAPSHOT.jar
```

**Windows:**
```
gradlew.bat build
cd ${PROJECT_ROOT_DIR}/build/libs/regestry-rest-api-0.1-SNAPSHOT.jar
java -jar regestry-rest-api-0.1-SNAPSHOT.jar
```

###Rodando Testes
**Linux ou Mac**
```
./gradlew test
```

**Windows:**
```
gradlew.bat test
```

###Postman

Segue minha coleção de comandos do Postman:

https://www.getpostman.com/collections/c96cb51b48521343dfed