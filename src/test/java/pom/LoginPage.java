package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private final String filePathToScreenshots =
            "C:\\Users\\Den_PC\\Desktop\\ness\\Selenium\\Projects\\nextProject\\assets\\login\\";

    @FindBy(id = "EmailOrAccountNumber")
    private WebElement emailEl;

    @FindBy(id = "Password")
    private WebElement passwordEl;

    @FindBy(id = "SignInNow")
    private WebElement signInEl;

    @FindBy(css = "div[class=\"error-description\"] a[class=\"link-btn\"]")
    private WebElement continueShoppingBtnEl;

    @FindBy(css = "[data-ga-guest-label=\"Sign-up-now\"]")
    private WebElement registerNowBtnEl;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(getWebDriver(), this);
    }

    @Step("Inserting {0} to email box")
    public void insertEmail(String email){
        waitElementLocated(emailEl);
        emailEl.sendKeys(email);
    }

    @Step("Inserting {0} to password box")
    public void insertPassword(String password){
        waitElementLocated(passwordEl);
        passwordEl.sendKeys(password);
    }

    @Step("Clicking on Sign In button")
    public void clickOnSignIn(){
        waitElementLocated(signInEl);
        signInEl.click();
    }

    @Step("Clicking on Register Now button")
    public RegistrationPage clickOnRegisterNow(){
        waitElementLocated(registerNowBtnEl);
        registerNowBtnEl.click();
        return new RegistrationPage(getWebDriver(), getWebDriverWait());
    }

    @Step("Sign in with email: {0} and password: {1}")
    public void login(String email, String password){
        insertEmail(email);
        insertPassword(password);
        clickOnSignIn();
    }

    @Step("Verify sign in")
    public boolean verifyLogin(){
        waitElementLocated(continueShoppingBtnEl);
        String fileName = "check_login\\check_login";
        takeScreenshot(filePathToScreenshots, fileName);
        return continueShoppingBtnEl.isDisplayed();
    }
}
