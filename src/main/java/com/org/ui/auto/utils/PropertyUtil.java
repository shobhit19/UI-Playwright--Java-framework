package com.org.ui.auto.utils;

import com.org.ui.auto.constants.FrameworkConstants;
import com.org.ui.auto.enums.ConfigProperties;
import com.org.ui.auto.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtil {

    private PropertyUtil(){

    }
    private static Properties properties = new Properties();

    static{
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            properties.load(fis);
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(ConfigProperties key){
        if(Objects.isNull(key) || Objects.isNull(key.name().toLowerCase())){
            throw new PropertyFileUsageException("**** There is issue in reading properties file ****");
        }
        return properties.getProperty(key.name().toLowerCase());
    }
}
