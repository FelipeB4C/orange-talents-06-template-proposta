package com.zup.proposta.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers(HttpMethod.POST, "/carteiras/**").hasAuthority("SCOPE_proposta-scope")
                        .antMatchers(HttpMethod.POST, "/avisos/*").hasAuthority("SCOPE_proposta-scope")
                        .antMatchers("/actuator/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/bloqueios").hasAuthority("SCOPE_proposta-scope")
                        .antMatchers(HttpMethod.POST, "/propostas").hasAuthority("SCOPE_proposta-scope")
                        .antMatchers(HttpMethod.GET, "/propostas/*").hasAuthority("SCOPE_proposta-scope")
                        .antMatchers(HttpMethod.POST, "/biometrias/*").hasAuthority("SCOPE_proposta-scope")
                        .anyRequest().authenticated()
        )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
