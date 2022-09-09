package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class Variables {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static String url;
    protected static String timeout;
    protected static WebBrowserType browserType;

    protected static HomePage homePage;
    protected static ListOfProductsPage listOfProductsPage;
    protected static ProductPage productPage;
    protected static ShoppingCartPage shoppingCartPage;
    protected static LoginPage loginPage;
    protected static RegistrationPage registrationPage;

    protected static String registrationDataFilePath;
    protected static String searchDataFilePath;

    protected static String screenShoppingCartFilePath;
    protected static String screenSearchFilePath;
    protected static String screenRegistrationFilePath;
    protected static String screenLoginFilePath;

    protected static String shoppingCartMsg1item;
    protected static String shoppingCartMsg2items;
    protected static String shoppingCartEmptyMsg;

    protected static String searchTerm;
}
