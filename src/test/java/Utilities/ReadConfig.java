package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;

    public ReadConfig()
    {
        File file= new File("./Configurations/config.properties");
        try
        {
            FileInputStream fileInput= new FileInputStream(file);
            properties= new Properties();
            properties.load(fileInput);
        }
        catch (Exception e)
        {
            System.out.println("Expection: "+ e.getMessage());

        }
    }

    public String getUrl()
    {
        String url= properties.getProperty("BaseUrl");
        return url;
    }

    public String getUsername()
    {
        String username= properties.getProperty("Username");
        return username;
    }

    public String getPassword()
    {
        String password= properties.getProperty("Password");
        return password;
    }

    public String getChromePath()
    {
        String chromePath= properties.getProperty("Chromepath");
        return chromePath;
    }
    public String getFirefoxPath()
    {
        String firefoxPath= properties.getProperty("Firefoxpath");
        return firefoxPath;
    }

}
