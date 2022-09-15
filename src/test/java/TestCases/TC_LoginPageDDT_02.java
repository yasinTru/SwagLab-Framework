package TestCases;

import PageObjects.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.XlUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginPageDDT_02 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDTCase(String username, String password) {


        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.submitButton();
        homePage.clickBurgerLayout();
        homePage.clickLogout();
        //Assert.assertTrue(true);

    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException
    {
        String dataPath= System.getProperty("user.dir")+"/src/test/java/TestData/SwagLabsData.xlsx";
        int rowCount= XlUtils.getRowCount(dataPath, "Sayfa1");
        int columnCount= XlUtils.getColumnCount(dataPath, "Sayfa1", 1);

        String loginData[][]= new String[rowCount][columnCount];
        for(int i=1; i<=rowCount;i++)
        {
            for(int j=0;j<columnCount;j++)
            {
                loginData[i-1][j]=XlUtils.getCellData(dataPath, "Sayfa1",i,j);
            }
        }
        return loginData;

    }

}
