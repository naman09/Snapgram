# Snapgram
Snapgram clone

[![Build and Test App](https://github.com/naman09/Snapgram/actions/workflows/github-actions-demo.yml/badge.svg)](https://github.com/naman09/Snapgram/actions/workflows/github-actions-demo.yml)

## Run local frontend
- npm install
- npm start

## Run local backend
- ./mvnw clean build
- run using IDE

## Data model
[Data model](https://app.diagrams.net/#G1yg6SCO9BjNiieXteEHKQUAWojveNmihG)
![Snapgram data model](backend/database/Snapgram-data-model.drawio.png)

## Setup HTTPS
-  Generate SSL certificate
```
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12  -validity 3650
```
- move keystore.p12 in `resources/keystore`
- Update application.properties
```
server.port= 443
server.ssl.key-store= classpath:keystore/keystore.p12
server.ssl.key-store-password= <PASSWORD-GIVEN-DURING-CERT_GEN>
server.ssl.keyStoreType= PKCS12
```

## TODO
- [ ] Write tests - unit tests, integration tests
- [ ] How to configure multiple env - Dev, QA, Stage, Prod
- [ ] How to configure secrets for DB
- [ ] Error handling using [ResponseStatusException](https://www.baeldung.com/spring-response-status-exception)
- [x] Add logs before and after method exec using Logging Aspect (AOP)
- [ ] Add global exception handler using Controller Advice
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DatabaseOperationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleDatabaseOperationException(DatabaseOperationException ex) {
        // Log the exception or perform other actions if needed
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
```
### Controller Advice vs RespnseStatusException
```
1. If you want to provide a unified and global way of exception handling make use of ControllerAdvice.
It also eliminates code duplication which might be caused by ResponseStatusException.

2. In order to throw different error code and responses for the same exception, don't want to create
custom exception classes and to avoid tight coupling make use of ResponseStatusException.
```
