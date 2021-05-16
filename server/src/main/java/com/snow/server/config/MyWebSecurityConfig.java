package com.snow.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/api/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                .exceptionHandling()
                    .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                    .and()
                .csrf().disable()
                .headers().frameOptions().disable().and()
                .formLogin()
                    .loginProcessingUrl("/api/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(new MyAuthenticationSuccessHandler())
                    .failureHandler((req, res, ex) -> {
                        res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    })
                    .and()
                .logout()
                    .logoutUrl("/api/logout")
                    .logoutSuccessHandler((req, res, ex) -> {
                        res.setStatus(HttpServletResponse.SC_OK);
                    });
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}