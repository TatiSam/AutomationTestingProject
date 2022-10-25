package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class LoginPage {
    @FindBy(id = "EmailOrAccountNumber")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "SignInNow")
    private WebElement signInButton;

    @FindBy(css = "div[class=\"error-description\"] a[class=\"link-btn\"]")
    private WebElement continueShoppingButton;

    @FindBy(css = "[data-ga-guest-label=\"Sign-up-now\"]")
    private WebElement registerNowButton;

    public WebElement getEmail(){
        return email;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getSignInButton(){
        return signInButton;
    }

    public WebElement getRegisterNowButton(){
        return registerNowButton;
    }

    public WebElement getContinueShoppingButton(){
        return continueShoppingButton;
    }
}
