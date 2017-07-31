package org.kpi.config;

import org.kpi.config.security.JWTAuthenticationFilter;
import org.kpi.config.security.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    private DataSource dataSource;

    //Spring Security / Queries for AuthenticationManagerBuilder
    @Value("select username, password, 1 from user where username=?")
    private String usersQuery;

    @Value("select u.username, r.name from user u inner join role r on(u.id=r.id) where u.username=?")
    private String rolesQuery;

    private static final String REALM = "KPI";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthenticationEntryPoint())
                .and().addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BasicAuthenticationEntryPoint getBasicAuthenticationEntryPoint() {
        BasicAuthenticationEntryPoint basic = new BasicAuthenticationEntryPoint();
        basic.setRealmName(REALM);
        return basic;
    }

    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
//        .antMatchers(HttpMethod.GET, "/styles/**")
//        .antMatchers(HttpMethod.GET, "/scripts/**")
//        .antMatchers(HttpMethod.GET, "/fonts/**")
        .antMatchers(HttpMethod.GET, "/images/**")
        .antMatchers(HttpMethod.GET, "/assets/**")
        .antMatchers(HttpMethod.GET, "/static/**");
    }
}
