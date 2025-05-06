package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ConfigReader {
    private static final Logger log = LogManager.getLogger(ConfigReader.class);

    private volatile static ConfigReader instance = null;

    private Properties properties;

    private ConfigReader() {

    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
            instance.loadProperties();
        }
        return instance;
    }

    /**
     * This method is used to load the properties from config.properties file
     */
    private void loadProperties() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("config/config.properties");
        try {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            log.error("Exception while reading config properties ", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
