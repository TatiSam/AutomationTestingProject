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
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static String url;
    public static String timeout;
    public static WebBrowserType browserType;

    public static HomePage homePage;
    public static ListOfProductsPage listOfProductsPage;
    public static ProductPage productPage;
    public static ShoppingCartPage shoppingCartPage;
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;

    public static String registrationDataFilePath;
    public static String searchDataFilePath;

    public static String screenShoppingCartFilePath;
    public static String screenSearchFilePath;
    public static String screenRegistrationFilePath;
    public static String screenLoginFilePath;

    public static String shoppingCartMsg1item;
    public static String shoppingCartMsg2items;
    public static String shoppingCartEmptyMsg;

    public static String searchTerm;
}
