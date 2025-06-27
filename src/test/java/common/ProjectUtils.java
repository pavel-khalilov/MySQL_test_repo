package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ProjectUtils {
    private static final Properties PROPERTIES = loadProperties();

    private ProjectUtils() {};

    public static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = ProjectUtils.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.out.println("db.properties file not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
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
