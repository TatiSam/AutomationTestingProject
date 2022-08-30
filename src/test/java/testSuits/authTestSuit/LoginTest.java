package testSuits.authTestSuit;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pom.HomePage;
import pom.LoginPage;
import testSuits.BaseTest;
import utils.WebBrowserType;
import utils.WebDriverUtils;

import java.time.Duration;

public class LoginTest extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        driver = getWebDriver();
        wait = getWebDriverWait();
    }

    @BeforeGroups({"sanity", "smoke", "regression"})
    public void setUpGroups(){
        if(driver == null){
            driver = WebDriverUtils.createDriver(WebBrowserType.CHROME);
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
    }

    @DataProvider(name = "correct_data")
    public Object[][] dataForLoginWithCorrectData(){
        return new Object[][] {
                {"tanicknom@gmail.com", "Y348d76Rt"}
        };
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Login with all correct data")
    @Story("Verify authentication functionality")
    @Test(dataProvider = "correct_data", groups = {"sanity", "smoke", "regression"})
    public void loginWithCorrectData(String email, String password){
        homePage = new HomePage(driver, wait);
        loginPage = homePage.clickOnMyAccountBtn();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.verifyLogin());
    }

    @DataProvider(name = "incorrect_password")
    public Object[][] dataForLoginWithIncorrectPassword(){
        return new Object[][] {
                {"tanicknom@gmail.com", "lk9i7y"}
        };
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Login with correct email and incorrect password")
    @Story("Verify authentication functionality")
    @Test(dataProvider = "incorrect_password", groups = {"smoke", "regression"})
    public void loginWithIncorrectPassword(String email, String password){
        homePage = new HomePage(driver, wait);
        loginPage = homePage.clickOnMyAccountBtn();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.verifyLogin());
    }
}
