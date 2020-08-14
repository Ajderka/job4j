package ru.job4j;

import logger.UsageLog4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Config {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    private static final Properties properties = new Properties();

    public static String getCronTime(String properties) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(properties)) {
            Properties config = new Properties();
            config.load(in);
            return config.getProperty("cron.time");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

//    public static Properties getProperties(String name) throws IOException {
//        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(name)) {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            LOG.error("Error", e);
//        }
//        return properties;
//    }

    public static Connection getConnection(String properties) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(properties)) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
