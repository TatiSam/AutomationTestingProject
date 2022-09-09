package utilities;

import org.openqa.selenium.support.PageFactory;
import pages.*;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class ManagePages extends Variables{

    public static void initPages() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        listOfProductsPage = PageFactory.initElements(driver, ListOfProductsPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    }
}
