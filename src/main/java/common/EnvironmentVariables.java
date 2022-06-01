package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentVariables {
    private Properties properties;
    private InputStream inputStream;

    private static final String GRADLE_PROPERTIES_FILE = "gradle.properties";

    public EnvironmentVariables(){
        this.loadProperties();
    }

    private void loadProperties() {
        try{
            properties = new Properties();
            inputStream = new FileInputStream(GRADLE_PROPERTIES_FILE);
            properties.load(inputStream);
        }catch(IOException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    public Properties env(){
        return this.properties;
    }
}
