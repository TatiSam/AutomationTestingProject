package shoppingCart;

import extensions.UIActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import utilities.CommonOps;
import utilities.TestListener;
import workFlows.ShoppingCartWorkFlows;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
@Listeners({TestListener.class})
public class ShoppingCartTest extends CommonOps{

    @BeforeMethod
    public void setUpTest(){
        UIActions.visit(url);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify added product is in the shopping cart")
    @Test(description = "Test added product is in the shopping cart")
    public void test01_shoppingCart(){
        ShoppingCartWorkFlows.findProductAndAddToShoppingCart();
        ShoppingCartWorkFlows.verifyMessageContains(shoppingCartMsg1item);
        ShoppingCartWorkFlows.removeProduct();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify when product was added to the cart twice, the quantity in the cart is 2")
    @Test(description = "Test added product twice to the shopping cart")
    public void test02_shoppingCart(){
        ShoppingCartWorkFlows.findProductAndAddToShoppingCart();
        ShoppingCartWorkFlows.findProductAndAddToShoppingCart();
        ShoppingCartWorkFlows.verifyQuantityOfProduct(2);
        ShoppingCartWorkFlows.removeProduct();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Verify changing quantity of product in shopping cart")
    @Test(description = "Test changing quantity of product in shopping cart")
    public void test03_shoppingCart(){
        ShoppingCartWorkFlows.findProductAndAddToShoppingCart();
        ShoppingCartWorkFlows.changeQuantityOfProducts();
        ShoppingCartWorkFlows.verifyQuantityOfProduct(2);
        ShoppingCartWorkFlows.removeProduct();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify total sum in shopping cart")
    @Test(description = "Test total sum in shopping cart")
    public void test04_shoppingCart(){
        ShoppingCartWorkFlows.findProductAndAddToShoppingCart();
        double total = ShoppingCartWorkFlows.getPrice()*2;
        ShoppingCartWorkFlows.changeQuantityOfProducts();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShoppingCartWorkFlows.verifyTotalSum(total);
        ShoppingCartWorkFlows.removeProduct();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify remove product from shopping cart")
    @Test(description = "Test remove product from shopping cart")
    public void test05_shoppingCart(){
        ShoppingCartWorkFlows.findProductAndAddToShoppingCart();
        ShoppingCartWorkFlows.removeProduct();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShoppingCartWorkFlows.verifyMessageEqual(shoppingCartEmptyMsg);
    }
}
