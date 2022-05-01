package company.project.backend.Security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Profile("dev")
@Configuration(proxyBeanMethods = false)
public class DevProfileSecurityConfiguration {
    /**
     * This section defines the security policy for the app.
     * - /employees is secured using URL security shown below
     * - CSRF headers are disabled since we are only testing the REST interface,
     *   not a web one.
     *
     * NOTE: GET is not shown which defaults to permit.
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.requestMatcher(PathRequest.toH2Console())
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/v1/*").anonymous()
                .antMatchers(HttpMethod.POST,"/api/v1/*").anonymous()
                .antMatchers(HttpMethod.PUT,"/api/v1/*").anonymous()
                .antMatchers(HttpMethod.DELETE,"/api/v1/*").anonymous()
                .antMatchers(HttpMethod.PATCH,"/api/v1/*").anonymous().and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin().and()
                .build();
    }

}