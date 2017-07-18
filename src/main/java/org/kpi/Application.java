package org.kpi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Application {
    public static void main(String[] args) throws IOException {
        // Path of the Kpi.properties in user.home
        String path = System.getProperty("user.home") + "/kpi.properties";

        File f = new File(path);
        if (f.canRead()) {
            FileInputStream propertiesFile = new FileInputStream(path);
            Properties p = new Properties(System.getProperties());
            p.load(propertiesFile);
            // set the system properties
            System.setProperties(p);
        }
        SpringApplication.run(Application.class, args);

    }
}
