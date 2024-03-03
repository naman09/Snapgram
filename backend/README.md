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