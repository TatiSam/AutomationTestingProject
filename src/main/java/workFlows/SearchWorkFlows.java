package workFlows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class SearchWorkFlows extends CommonOps {

    @Step("Search term: {0}")
    public static void searchTerm(String term){
        UIActions.sendKeysToElement(homePage.getSearchBox(), term);
        UIActions.clickElement(homePage.getSearchButton());
    }

    @Step("Add tow first products to shopping cart")
    public static void addTowFirstProductsToShoppingCart(){
        UIActions.clickElement(listOfProductsPage.getFirstResult());
        addProductToShoppingCart();
        UIActions.goBack();
        UIActions.clickElement(listOfProductsPage.getSecondResult());
        addProductToShoppingCart();
        UIActions.clickElement(productPage.getShoppingBagButton());
        UIActions.clickElement(productPage.getViewBagButton());
    }

    @Step("Verify plp result is equal to: {0}")
    public static void verifyPlpResult(String str){
        Verifications.verifyTextContains(getPlpResult(), str);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify plp count results is greater than: {0}")
    public static void verifyPlpCountResults(int min){
        Verifications.verifyCountMore(getPlpCountResults(), min);
    }

    @Step("Verify first result name contains: {0}")
    public static void verifyFirstResultName(String str){
        Verifications.verifyTextContains(getFirstResultName(), str);
    }

    @Step("Verify second result name contains: {0}")
    public static void verifySecondResultName(String str){
        Verifications.verifyTextContains(getSecondResultName(), str);
    }

    private static void addProductToShoppingCart(){
        UIActions.waitElementLocated(productPage.getChooseSize());
        UIActions.clickElement(productPage.getChooseSize());
        UIActions.clickElement(productPage.getFirstSize());
        UIActions.clickElement(productPage.getAddToBagButton());
    }

    private static String getPlpResult(){
        return listOfProductsPage.getPlpResult().getText().toLowerCase();
    }

    private static int getPlpCountResults(){
        return Integer.parseInt(listOfProductsPage.getPlpCountResults().getText().split(" ")[0]);
    }

    private static String getFirstResultName(){
        return listOfProductsPage.getFirstResult().getText().toLowerCase();
    }

    private static String getSecondResultName(){
        return listOfProductsPage.getSecondResult().getText().toLowerCase();
    }
}
