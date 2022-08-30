package testSuits.ShoppingCartTestSuit;

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
import pom.ShoppingCartPage;
import testSuits.BaseTest;
import utils.WebBrowserType;
import utils.WebDriverUtils;

import java.time.Duration;

public class ShoppingCartTest extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ListOfProductsPage listOfProductsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that added product is in the shopping cart")
    @Story("Verify shopping cart functionality")
    @Test(groups = "regression")
    public void checkAddProduct(){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.findProduct();
        ProductPage productPage = listOfProductsPage.clickOnFirstResult();
        String itemNumber = productPage.putProductToShoppingCart();
        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyItemNumber(itemNumber));
        shoppingCartPage.removeProduct();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that when product was added to the cart twice, the quantity in the cart is 2")
    @Story("Verify shopping cart functionality")
    @Test(groups = "regression")
    public void checkAddTowProducts(){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.findProduct();
        ProductPage productPage = listOfProductsPage.clickOnFirstResult();
        productPage.putProductToShoppingCart();
        homePage.findProduct();
        listOfProductsPage.clickOnFirstResult();
        productPage.putProductToShoppingCart();
        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyCountOfProduct(2));
        shoppingCartPage.removeProduct();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Check that it's possible to change the quantity of product in the cart")
    @Story("Verify shopping cart functionality")
    @Test(groups = "regression")
    public void checkChangeCount(){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.findProduct();
        ProductPage productPage = listOfProductsPage.clickOnFirstResult();
        productPage.putProductToShoppingCart();
        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart();
        shoppingCartPage.changeCountOfProducts();
        Assert.assertTrue(shoppingCartPage.verifyCountOfProduct(2));
        shoppingCartPage.removeProduct();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that total sum in shopping cart is equal to sum of product prices")
    @Story("Verify shopping cart functionality")
    @Test(groups = "regression")
    public void checkTotalSum(){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.findProduct();
        ProductPage productPage = listOfProductsPage.clickOnFirstResult();
        productPage.putProductToShoppingCart();
        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart();
        double total = shoppingCartPage.getPriceOfProduct() * 2;
        shoppingCartPage.changeCountOfProducts();
        Assert.assertTrue(shoppingCartPage.verifyTotalSum(total));
        shoppingCartPage.removeProduct();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Check that after delete product from shopping cart, shopping cart is empty")
    @Story("Verify shopping cart functionality")
    @Test(groups = "regression")
    public void checkDeleteProduct(){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.findProduct();
        ProductPage productPage = listOfProductsPage.clickOnFirstResult();
        productPage.putProductToShoppingCart();
        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart();
        shoppingCartPage.removeProduct();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage.verifyMessage("your bag contains 0 item and comes to a total of ₪ 0.00."));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check that product is in the shopping cart when we enter after exit from it")
    @Story("Verify shopping cart functionality")
    @Test(groups = "regression")
    public void checkEnterAndExit(){
        homePage = new HomePage(driver, wait);
        ListOfProductsPage listOfProductsPage = homePage.findProduct();
        ProductPage productPage = listOfProductsPage.clickOnFirstResult();
        productPage.putProductToShoppingCart();
        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart();
        String itemNumber = shoppingCartPage.getItemNumber();
        shoppingCartPage.exitFromShoppingCart();
        homePage.clickOnShoppingCart();
        Assert.assertTrue(shoppingCartPage.verifyItemNumber(itemNumber));
        shoppingCartPage.removeProduct();
    }
}
