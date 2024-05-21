package com.org.ui.auto.constants;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    public static final String RESOURCE_PATH = System.getProperty("user.dir")+"/src/test/resources";
    public static final String CONFIG_FILE_PATH=RESOURCE_PATH+"/config/config.properties";

    public static String  getConfigFilePath(){
        return CONFIG_FILE_PATH;
    }
}
