package PageObjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver localDriver;

    public HomePage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }


    @FindBy(className = "app_logo")
    @CacheLookup
    WebElement homeLogo;

    @FindBy(id = "react-burger-menu-btn")
    @CacheLookup
    WebElement burgerLayoutBtn;

    @FindBy(id = "logout_sidebar_link")
    @CacheLookup
    WebElement logoutBtn;

    @FindBy(className = "error-message-container")
    @CacheLookup
    WebElement loginErrorMsg;

    public boolean checkLogoVisibility() {
        if (homeLogo.isDisplayed())
        {
         return true;
        }
        else return false;
    }


    public void clickBurgerLayout() {
        burgerLayoutBtn.click();
    }

    public void clickLogout() {
        logoutBtn.click();
    }

    public boolean checkErrorMsg() {
        if (loginErrorMsg.isDisplayed())
        {
            return true;
        }
        else return false;
    }
}

