package company.project.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((authorize) -> {
            authorize.antMatchers("/h2-console/**").permitAll();
            authorize.antMatchers("/login", "/resources/**").permitAll();
            authorize.antMatchers("/webjars/**").permitAll();
            authorize.antMatchers("/api/v1/ts1000/auto/updateConflictArs/**").permitAll();
            authorize.antMatchers("/api/v1/ts1000/auto/enableArs").permitAll();
        })
//        .authorizeRequests()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin(formLoginConfigurer -> {
//            formLoginConfigurer
//                    .loginProcessingUrl("/login")
//                    .loginPage("/login").permitAll()
//                    .successForwardUrl("/")
//                    .defaultSuccessUrl("/")
//                    .failureUrl("/login?error");
//        })
//        .logout(logOutConfigurer -> {
//            logOutConfigurer.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//                .logoutSuccessUrl("/login/?logout")
//                .permitAll();
//        })
        .httpBasic()
                .and().csrf().ignoringAntMatchers("/h2-console/**",
                    "/api/v1/ts1000/actual/export-Actual",
                    "/api/v1/ts1000/ars/disable");
        http.headers().frameOptions().sameOrigin();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return TsPasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
