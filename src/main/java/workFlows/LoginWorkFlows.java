package workFlows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;

import static utilities.Variables.*;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class LoginWorkFlows {
    @Step("Login with email: {0} and password: {1}")
    public static void login(String email, String password){
        UIActions.clickElement(homePage.getMyAccountButton());
        UIActions.sendKeysToElement(loginPage.getEmail(), email);
        UIActions.sendKeysToElement(loginPage.getPassword(), password);
        UIActions.clickElement(loginPage.getSignInButton());
    }

    @Step("Go to Hope page")
    public static void goToHomePage(){
        UIActions.visit(url);
    }

    @Step("Verify  login")
    public static void verifyLogin(){
        Verifications.isDisplayed(loginPage.getContinueShoppingButton());
        UIActions.takeScreenshotToAllureReport();
    }
}
