package com.fs.app.automation.Misc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import static java.lang.System.out;


public class Props {
    private static final Logger LOG = LoggerFactory.getLogger(Props.class);
    private static Properties properties;
    private static InputStream input = null;
    /**
     * Gets the key from messages.properties for a Site
     *
     * @param key
     **/
    public static String getMessage(String key) {

        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return ResourceBundle.getBundle("props/messages").getString(key);

        }
    }

    /**
     * Gets the key from Config.properties related to chosen profile
     *
     * @param key
     **/

    public static String getProp(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return properties.getProperty(key);

        }
    }

    /**
     * Gets the key from System properties defined
     *
     * @param key
     **/

    public static String getSystemProp(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return System.getProperty(key);

        }
    }
    public static void loadRunConfigProps() {
        properties = new Properties();
        //try (InputStream inputStream = Props.class.getResourceAsStream(properties.getProperty("/profiles/local/config.properties"))) {
        try {
            input = new FileInputStream("C:\\Users\\Vinay.Misra\\Automation\\fs-master\\src\\main\\resources\\profiles\\local\\config.properties");
            properties.load(input);
            properties.list(out);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

}
