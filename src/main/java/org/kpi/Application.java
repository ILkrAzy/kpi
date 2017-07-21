package org.kpi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static String ARGUMENT_LOCATION = "--spring.config.location";
    private static String HOME_LOCATION = "user.home";
    private static String FILE_KPI_NAME = "/kpi.properties";

    public static void main(String[] args) throws IOException {
        if (!checkFileExist(findDirectory(args))) {
            loadUserProperties();
        }
        SpringApplication.run(Application.class, args);
    }

    private static String findDirectory(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i].toString();
            String[] splittedArg = arg.split("=");
            if (splittedArg[0].equals(ARGUMENT_LOCATION) && splittedArg.length == 2) {
                return splittedArg[1];
            }
        }
        return null;
    }

    private static boolean checkFileExist(String path) {
        try {
            File file = new File(path);
            if (!file.exists() && !file.isDirectory()) {
                System.out.println(path + " Not found.");
            }
            return (file.exists() && !file.isDirectory());

        } catch (Exception ex) {
            return false;
        }
    }

    private static void loadUserProperties() throws IOException {
        String path = System.getProperty(HOME_LOCATION) + FILE_KPI_NAME;
        if (checkFileExist(path)) {
            FileInputStream propertiesFile = new FileInputStream(path);
            Properties p = new Properties(System.getProperties());
            p.load(propertiesFile);
            System.setProperties(p);
        }
    }
}
