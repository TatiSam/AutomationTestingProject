package testSuits.authTestSuit;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pom.HomePage;
import pom.LoginPage;
import pom.RegistrationPage;
import testSuits.BaseTest;
import utils.WebBrowserType;
import utils.ExelUtils;
import utils.WebDriverUtils;

import java.time.Duration;

public class RegistrationTest extends BaseTest {
    private final String fileName = "next-registration.xlsx";
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private ExelUtils eu = new ExelUtils();

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

    @DataProvider(name = "valid-data")
    public Object[][] dataForRegisterWithValidData(){
        return eu.readExelFile(fileName, 0, 12);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Registration with all valid data")
    @Story("Verify registration functionality")
    @Test(dataProvider = "valid-data", groups = {"sanity", "smoke", "regression"})
    public void registerWithValidData(String title, String fName, String lName,
                                      String email, String password,
                                      String phone, String apartment,
                                      String street, String town,
                                      String state, String zip, String expectedResult){
        homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.clickOnMyAccountBtn();
        RegistrationPage registrationPage = loginPage.clickOnRegisterNow();
        String str = registrationPage.registerWithValidData(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        Assert.assertEquals(str, expectedResult);
    }

    @DataProvider(name = "firstname-invalid")
    public Object[][] dataForRegisterWithFirstNameInvalid(){
        return eu.readExelFile(fileName, 1, 12);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Registration with valid data and firstName invalid")
    @Story("Verify registration functionality")
    @Test(dataProvider = "firstname-invalid", groups = {"smoke", "regression"})
    public void registerWithFirthNameInvalid(String title, String fName, String lName,
                                             String email, String password,
                                             String phone, String apartment,
                                             String street, String town,
                                             String state, String zip, String expectedResult){
        homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.clickOnMyAccountBtn();
        RegistrationPage registrationPage = loginPage.clickOnRegisterNow();
        String str = registrationPage.registerWithFirstNameInvalid(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        Assert.assertEquals(str, expectedResult);
    }

    @DataProvider(name = "lastname-invalid")
    public Object[][] dataForRegisterWithLastNameInvalid(){
        return eu.readExelFile(fileName, 2, 12);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Registration with valid data and lastName invalid")
    @Story("Verify registration functionality")
    @Test(dataProvider = "lastname-invalid", groups = {"smoke", "regression"})
    public void registerWithLastNameInvalid(String title, String fName, String lName,
                                            String email, String password,
                                            String phone, String apartment,
                                            String street, String town,
                                            String state, String zip, String expectedResult){
        homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.clickOnMyAccountBtn();
        RegistrationPage registrationPage = loginPage.clickOnRegisterNow();
        String str = registrationPage.registerWithLastNameInvalid(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        Assert.assertEquals(str, expectedResult);
    }

    @DataProvider(name = "email-invalid")
    public Object[][] dataForRegisterWithEmailInvalid(){
        return eu.readExelFile(fileName, 3, 12);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Registration with valid data and email invalid")
    @Story("Verify registration functionality")
    @Test(dataProvider = "email-invalid", groups = {"smoke", "regression"})
    public void registerWithEmailInvalid(String title, String fName, String lName,
                                         String email, String password,
                                         String phone, String apartment,
                                         String street, String town,
                                         String state, String zip, String expectedResult){
        homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.clickOnMyAccountBtn();
        RegistrationPage registrationPage = loginPage.clickOnRegisterNow();
        String str = registrationPage.registerWithEmailInvalid(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        Assert.assertEquals(str, expectedResult);
    }

    @DataProvider(name = "password-invalid")
    public Object[][] dataForRegisterWithPasswordInvalid(){
        return eu.readExelFile(fileName, 4, 12);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Registration with valid data and password invalid")
    @Story("Verify registration functionality")
    @Test(dataProvider = "password-invalid", groups = {"smoke", "regression"})
    public void registerWithPasswordInvalid(String title, String fName, String lName,
                                            String email, String password,
                                            String phone, String apartment,
                                            String street, String town,
                                            String state, String zip, String expectedResult){
        homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.clickOnMyAccountBtn();
        RegistrationPage registrationPage = loginPage.clickOnRegisterNow();
        String str = registrationPage.registerWithPasswordInvalid(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        Assert.assertEquals(str, expectedResult);
    }

    @DataProvider(name = "phone-invalid")
    public Object[][] dataForRegisterWithPhoneInvalid(){
        return eu.readExelFile(fileName, 5, 12);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Registration with valid data and phoneNumber invalid")
    @Story("Verify registration functionality")
    @Test(dataProvider = "phone-invalid", groups = {"smoke", "regression"})
    public void registerWithPhoneNumberInvalid(String title, String fName, String lName,
                                               String email, String password,
                                               String phone, String apartment,
                                               String street, String town,
                                               String state, String zip, String expectedResult){
        homePage = new HomePage(driver, wait);
        LoginPage loginPage = homePage.clickOnMyAccountBtn();
        RegistrationPage registrationPage = loginPage.clickOnRegisterNow();
        String str = registrationPage.registerWithPhoneNumberInvalid(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        Assert.assertEquals(str, expectedResult);
    }
}
