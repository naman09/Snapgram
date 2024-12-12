## H2 console
https://localhost/snapgram/api/v1/h2-console

*** BEST PRACTICES ***

Logger slf4j
 private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

Caching

Use builder pattern to return response

HTTPS
create TLS certificate - https://letsencrypt.org/docs/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requiresChannel().requiresSecure();
	}
}

create DTO layer

ResponseEntityExceptionHandler

GoodCookie

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
- [x] Set base url
- [x] Setup Postman
- [x] Setup DB
- [x] setup 1 DAO layer
- [x] auto increment in create user
- [x] setup LOKI
- [x] setup grafana
- [x] push a test log file to loki
- [ ] setup logging to log into file
- [ ] setup Prometheus
- [ ] How to configure secrets for DB
- [ ] Write tests - unit tests, integration tests
- [ ] How to configure multiple env - Dev, QA, Stage, Prod
- [ ] Error handling using [ResponseStatusException](https://www.baeldung.com/spring-response-status-exception)
- [x] Add logs before and after method exec using Logging Aspect (AOP)
- [x] Add global exception handler using Controller Advice

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

### Loki
```bash
docker network create logging-network

# Run loki http://localhost:3100/metrics
docker run --name loki -d -v C:\dev\Snapgram\backend\loki:/mnt/config -p 3100:3100 --network logging-network grafana/loki:3.2.1 -config.file=/mnt/config/loki-config.yml 
```

```bash
# Run grafana alloy http://localhost:12345/ui
docker run --name grafana-alloy -d -v C:\dev\Snapgram\backend\grafana-alloy\config.alloy:/etc/alloy/config.alloy -v C:\dev\Snapgram\backend\loki\log:/var/log/snapgram -p 12345:12345 --network logging-network grafana/alloy:latest run --server.http.listen-addr=0.0.0.0:12345 --storage.path=/var/lib/alloy/data /etc/alloy/config.alloy
```

```bash 
# Run grafana http://localhost:3000/
docker run -d -p 3000:3000  --network logging-network --name=grafana grafana/grafana-oss
```
[Reference:](https://www.youtube.com/watch?v=_W3R2VwRyF4&list=WL&index=20&ab_channel=JavaScriptMastery)