package com.example.Snapgram;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SnapgramApplication {
	public static void main(String[] args) {
		SpringApplication.run(SnapgramApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}

//*** BEST PRACTICES ***

//Logger slf4j
// private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

//Caching

//Use builder pattern to return response

//HTTPS
//create TLS certificate - https://letsencrypt.org/docs/
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.requiresChannel().requiresSecure();
//	}
//}

//create DTO layer

//ResponseEntityExceptionHandler