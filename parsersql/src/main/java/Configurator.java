import logger.UsageLog4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurator {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    private final Properties properties = new Properties();

    public Properties getProperties(String name) throws IOException{
        try (InputStream inputStream = Configurator.class.getClassLoader().getResourceAsStream(name)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.error("Error", e);
        }
        return properties;
    }

    public String get(String key) {
        return this.properties.getProperty(key);
    }
}
