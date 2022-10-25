package workFlows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;

import static utilities.Variables.*;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class ShoppingCartWorkFlows {
    @Step("Find product and add to shopping cart")
    public static void findProductAndAddToShoppingCart(){
        UIActions.hoverOverElement(homePage.getNavBarGirlsLink());
        UIActions.clickElement(homePage.getNavBarJeansLink());
        UIActions.clickElement(listOfProductsPage.getFirstResult());
        UIActions.clickElement(productPage.getChooseSize());
        UIActions.clickElement(productPage.getFirstSize());
        UIActions.clickElement(productPage.getAddToBagButton());
        UIActions.clickElement(productPage.getShoppingBagButton());
        UIActions.clickElement(productPage.getViewBagButton());
    }

    @Step("Change count of product in shopping cart")
    public static void changeQuantityOfProducts(){
        UIActions.clickElement(shoppingCartPage.getQuantity());
        UIActions.clickElement(shoppingCartPage.getChangeQuantity());
    }

    @Step("Remove product from shopping cart")
    public static void removeProduct() {
        UIActions.clickElement(shoppingCartPage.getRemove());
    }

    @Step("Verify quantity of product is equal to: {0}")
    public static void verifyQuantityOfProduct(int count){
        Verifications.verifyCountEquals(getQuantity(), count);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify total sum is equal to: {0}")
    public static void verifyTotalSum(double total){
        Verifications.verifyCountEquals(getTotalSum(), total);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify message is equal to: {0}")
    public static void verifyMessageEqual(String msg){
        Verifications.verifyTextEquals(getMessage(), msg);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify message contain: {0}")
    public static void verifyMessageContains(String msg){
        Verifications.verifyTextContains(getMessage(), msg);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Get price of product")
    public static double getPrice(){
        String price = shoppingCartPage.getPrice().getText().substring(1);
        return Double.parseDouble(price);
    }

    private static int getQuantity(){
        return Integer.parseInt(shoppingCartPage.getQuantity().getText());
    }

    private static double getTotalSum() {
        String total = shoppingCartPage.getTotal().getText().substring(1);
        return Double.parseDouble(total);
    }

    private static String getMessage(){
        UIActions.waitElementLocated(shoppingCartPage.getMessage());
        return shoppingCartPage.getMessage().getText().toLowerCase();
    }
}
