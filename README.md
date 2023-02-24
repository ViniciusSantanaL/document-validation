# API Rest With Spring Boot
## _DOCUMENT-VALIDATION-API_

This project is a microsservice construct with Spring Boot Framework. Then, your principal function is validation CPF document.

> Link Application on Heroku: `https://document-validation.herokuapp.com/` 

## Features

- Documennt Validation for CPF

## Necessary Dependencies

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Dependecies | Link |
| ------ | ------ |
| Java 17 | https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html |
| Maven | https://maven.apache.org/install.html |


## How to Run Application

After install dependencies and clone project, open terminal/prompt in directory project, and run this comands:

### Maven
In project root, execute:
```sh
mvn clean install
mvn package -f pom.xml
```

### Java
In project root, execute de final commands:
```sh
java -jar target/api-0.0.1-SNAPSHOT.jar
```

## How to Use Application
The apoplication listen in http://localhost:8080, and you can validate doc in 

```sh
    http://localhost:8081/users/${document_number}
```
