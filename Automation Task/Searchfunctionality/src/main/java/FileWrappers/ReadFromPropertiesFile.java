package FileWrappers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {
    static String fileNamePath = "src/test/resources/Config.properties";
    public static Properties properties = new Properties();

    static {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(fileNamePath);
            properties.load(fs);
        } catch (IOException e) {
            LoggingHandling.logError(e);
        } finally {
            try {
                assert fs != null;
                fs.close();

            } catch (IOException e) {
                LoggingHandling.logError(e);
            }

        }

    }

    public static String getValue(String Key) {
        try {
            return properties.getProperty(Key);
        } catch (Exception ex) {
            LoggingHandling.logError(ex);
            return null;
        }
    }
}
