package TestCases;

import PageObjects.BaseClass;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginPage_01 extends BaseClass {

    @Test
    public void LoginTest()
    {
        LoginPage loginPage= new LoginPage(driver);
        driver.get(baseUrl);
        logger.info("Website is running");

        loginPage.setUsername(baseUsername);
        logger.info("Username entered");
        loginPage.setPassword(basePassword);
        logger.info("Password entered");
        loginPage.submitButton();

        if (driver.getTitle().equals("Swag Labs"))
        {
            Assert.assertTrue(true);
            logger.info("Login Page opened");
        }
        else
        {
            Assert.assertTrue(false);
            logger.warn("Login page not opened");
        }

    }
}
