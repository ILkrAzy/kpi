package org.kpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
