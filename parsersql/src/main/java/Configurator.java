import logger.UsageLog4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurator {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    public static Properties getProperties(String name) {
        Properties properties = new Properties();
        try (InputStream inputStream = Configurator.class.getClassLoader().getResourceAsStream(name)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.error("Error", e);
        }
        return properties;
    }
}
