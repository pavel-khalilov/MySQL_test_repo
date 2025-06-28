package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ProjectUtils {
    private static final Properties PROPERTIES = loadProperties();
    private static final String CI = "CI";

    private ProjectUtils() {};

    public static boolean isCI() {
        return "true".equalsIgnoreCase(System.getenv(CI));
    }

    public static Properties loadProperties() {
        Properties properties = new Properties();

        if (isCI()) {
            properties.putAll(System.getenv());
            System.out.println("Credentials loaded from CI environment");
        } else {
            try (InputStream inputStream = ProjectUtils.class.getClassLoader().getResourceAsStream("db.properties")) {
                if (inputStream != null) {
                    properties.load(inputStream);
                    System.out.println("Credentials loaded from 'db.properties' file");
                } else {
                    System.out.println("db.properties file not found");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static String getUrl() {
        return PROPERTIES.getProperty("db.url");
    }

    public static String getUser() {
        return PROPERTIES.getProperty("db.user");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("db.password");
    }
}
