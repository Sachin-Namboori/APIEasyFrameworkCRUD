package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigManager {



        private static ConfigManager manager;
        private static final Properties prop = new Properties();


    private ConfigManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/resource/config.properties");
   //         InputStream inputStream = ConfigManager.class.getResourceAsStream("../resource/config.properties");
             prop.load(fis);

        }

        public static ConfigManager getInstance () {
            if (manager == null) {
                synchronized (ConfigManager.class) {
                    try {
                        manager = new ConfigManager();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return manager;
        }
        public String getString (String key){
            return System.getProperty(key, prop.getProperty(key));
        }

    }

