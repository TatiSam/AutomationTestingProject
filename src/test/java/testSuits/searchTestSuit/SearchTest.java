package testSuits.searchTestSuit;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pom.HomePage;
import pom.ListOfProductsPage;
import pom.ProductPage;
import testSuits.BaseTest;
import utils.WebBrowserType;
import utils.ExelUtils;
import utils.WebDriverUtils;

import java.time.Duration;

public class SearchTest extends BaseTest {
    private final String fileName = "next-search.xlsx";
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ListOfProductsPage listOfProductsPage;
    private ProductPage productPage;

    @BeforeClass
    public void setUp(){
        driver = getWebDriver();
        wait = getWebDriverWait();
    }

    @BeforeGroups({"regression"})
    public void setUpGroups(){
        if(driver == null){
            driver = WebDriverUtils.createDriver(WebBrowserType.CHROME);
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
    }

    @DataProvider(name = "search-term-data")
    public Object[][] dataForSearch(){
        ExelUtils eu = new ExelUtils();
        return eu.readExelFile(fileName, 0, 1);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check search term")
    @Story("Verify search functionality")
    @Test(dataProvider = "search-term-data", groups = "regression")
    public void checkSearchTerm(String term){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.search(term);
        Assert.assertTrue(listOfProductsPage.verifyPlpResult(term));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check count results of search term")
    @Story("Verify search functionality")
    @Test(dataProvider = "search-term-data", groups = "regression")
    public void checkCountResults(String term){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.search(term);
        Assert.assertTrue(listOfProductsPage.verifyPlpCountResults(0));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check first result of search term")
    @Story("Verify search functionality")
    @Test(dataProvider = "search-term-data", groups = "regression")
    public void checkFirstResult(String term){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.search(term);
        Assert.assertTrue(listOfProductsPage.verifyFirstResultName(term));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check equals price of first result with price from details page")
    @Story("Verify search functionality")
    @Test(dataProvider = "search-term-data", groups = "regression")
    public void checkPrice(String term){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.search(term);
        String price = listOfProductsPage.getFirstResultPrice();
        ProductPage productPage = listOfProductsPage.clickOnFirstResult();
        Assert.assertTrue(productPage.verifyPrice(price));
    }
}
