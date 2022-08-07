package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties initializeProperties() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configurations/global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }
}
