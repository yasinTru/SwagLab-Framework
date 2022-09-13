package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver localDriver;

   public LoginPage(WebDriver remoteDriver)
    {
        localDriver= remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }

    @FindBy(id= "user-name")
    @CacheLookup
    WebElement usernameTxt;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordTxt;

    @FindBy(id= "login-button")
    @CacheLookup
    WebElement loginBtn;

    public void setUsername(String BaseUserName)
    {
        usernameTxt.sendKeys(BaseUserName);
    }

    public void setPassword(String BasePassword)
    {
        passwordTxt.sendKeys(BasePassword);
    }

    public void submitButton()
    {
        loginBtn.click();
    }

}
