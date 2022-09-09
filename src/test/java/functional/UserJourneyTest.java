package functional;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import utilities.TestListener;
import workFlows.LoginWorkFlows;
import workFlows.SearchWorkFlows;
import workFlows.ShoppingCartWorkFlows;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
@Listeners({TestListener.class})
public class UserJourneyTest extends CommonOps{

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login successful")
    @Test(
            priority = 1,
            dataProvider = "correctDataLogin",
            dataProviderClass = ManageDDT.class,
            description = "Test login successful"
    )
    public void test01_userJourney(String email, String password) {
        LoginWorkFlows.login(email, password);
        LoginWorkFlows.verifyLogin();
        LoginWorkFlows.goToHomePage();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify search process")
    @Test(
            priority = 2,
            description = "Test search process"
    )
    public void test02_userJourney(){
        SearchWorkFlows.searchTerm(searchTerm);
        SearchWorkFlows.verifyPlpResult(searchTerm);
        SearchWorkFlows.verifyPlpCountResults(2);
        SearchWorkFlows.verifyFirstResultName(searchTerm);
        SearchWorkFlows.verifySecondResultName(searchTerm);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify add product to shopping cart")
    @Test(
            priority = 3,
            description = "Test add product to shopping cart"
    )
    public void test03_userJourney(){
        SearchWorkFlows.addTowFirstProductsToShoppingCart();
        ShoppingCartWorkFlows.verifyMessageContains(shoppingCartMsg2items);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify remove product from shopping cart")
    @Test(
            priority = 4,
            description = "Test remove product from shopping cart"
    )
    public void test04_userJourney(){
        ShoppingCartWorkFlows.removeProduct();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShoppingCartWorkFlows.verifyMessageContains(shoppingCartMsg1item);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify change quantity of product in shopping cart")
    @Test(
            priority = 5,
            description = "Test change quantity of product in shopping cart")
    public void test05_userJourney(){
        double total = ShoppingCartWorkFlows.getPrice()*2;
        ShoppingCartWorkFlows.changeQuantityOfProducts();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShoppingCartWorkFlows.verifyQuantityOfProduct(2);
        ShoppingCartWorkFlows.verifyTotalSum(total);
    }
}
