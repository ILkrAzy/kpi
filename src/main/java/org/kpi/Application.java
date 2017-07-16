package org.kpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@Configuration
@PropertySources({
@PropertySource(value = "file:${user.home}/Kpi.properties", ignoreResourceNotFound = true),
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true) })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
