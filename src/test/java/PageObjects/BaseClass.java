package PageObjects;


import Utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
    ReadConfig readConfig= new ReadConfig();
    public String baseUrl= readConfig.getUrl();
    public String baseUsername= readConfig.getUsername();
    public String basePassword= readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;


    @BeforeClass
    @Parameters("browser")
    public void setup(String br)
    {
        logger= Logger.getLogger("driver stands up");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();

        } else if (br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        driver.get(baseUrl);

    }

    @AfterClass
    public void endDriver()
    {
        driver.quit();
    }
}
