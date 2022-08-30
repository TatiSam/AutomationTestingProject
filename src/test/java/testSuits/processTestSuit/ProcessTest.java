package testSuits.processTestSuit;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.*;
import testSuits.BaseTest;

public class ProcessTest extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;
    private ListOfProductsPage listOfProductsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    @BeforeClass
    public void setUp(){
        driver = getWebDriver();
        wait = getWebDriverWait();
    }

    @DataProvider(name = "login_data")
    public Object[][] dataForLogin(){
        return new Object[][] {
                {"tanicknom@gmail.com", "Y348d76Rt"}
        };
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Login")
    @Story("Verify process login-search-shop")
    @Test(priority = 1, dataProvider = "login_data")
    public void login(String email, String password){
        homePage = new HomePage(driver, wait);
        loginPage = homePage.clickOnMyAccountBtn();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.verifyLogin());
    }

    @DataProvider(name = "search_data")
    public Object[][] dataForSearch(){
        return new Object[][] {
                {"girls jeans"}
        };
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Search term")
    @Story("Verify process login-search-shop")
    @Test(priority = 2, dataProvider = "search_data")
    public void searchTerm(String term){
        homePage = new HomePage(driver, wait);
        listOfProductsPage = homePage.search(term);
        String price = listOfProductsPage.getFirstResultPrice();
        productPage = listOfProductsPage.clickOnFirstResult();
        productPage.putProductToShoppingCart();
        Assert.assertEquals(price, productPage.getPrice());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check shopping cart")
    @Story("Verify process login-search-shop")
    @Test(priority = 3)
    public void checkShoppingCart(){
        String itemNumberInProductPage = productPage.getItemNumber();
        shoppingCartPage = productPage.goToShoppingCart();
        String itemNumberInShoppingCartPage = shoppingCartPage.getItemNumber();
        Assert.assertEquals(itemNumberInShoppingCartPage, itemNumberInProductPage);
    }
}
