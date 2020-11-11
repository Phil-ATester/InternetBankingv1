package com.InternetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig(){

        File src = new File("./Configuration/Config.properties");

        try{
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        }catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL(){ return properties.getProperty("baseURL"); }

    public String getUserName(){
        return properties.getProperty("userName");
    }
    public String getPassword(){
        return properties.getProperty("passWord");
    }

    public String getChromePath(){ return properties.getProperty("chromePath"); }
}
