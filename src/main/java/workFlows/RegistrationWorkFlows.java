package workFlows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class RegistrationWorkFlows extends CommonOps {

    @Step("Registration")
    public static void register(String title, String firstName, String lastName,
                                        String email, String password,
                                        String phone, String apartment,
                                        String street, String town,
                                        String state, String zip){
        UIActions.clickElement(homePage.getMyAccountButton());
        UIActions.clickElement(loginPage.getRegisterNowButton());
        inputData(title, firstName, lastName, email, password, phone, apartment, street,
                town, state, zip);
    }

    @Step("Verify registration was successful")
    public static void verifyRegistration(){
        Verifications.isDisplayed(registrationPage.getContinueShoppingButton());
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify first name error is equal to: {0}")
    public static void verifyFirstNameError(String str){
        Verifications.verifyTextEquals(getFirstNameError(), str);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify last name error is equal to: {0}")
    public static void verifyLastNameError(String str){
        Verifications.verifyTextEquals(getLastNameError(), str);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify email error is equal to: {0}")
    public static void verifyEmailError(String str){
        Verifications.verifyTextEquals(getEmailError(), str);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify password error is equal to: {0}")
    public static void verifyPasswordError(String str){
        Verifications.verifyTextEquals(getPasswordError(), str);
        UIActions.takeScreenshotToAllureReport();
    }

    @Step("Verify phone number error is equal to: {0}")
    public static void verifyPhoneNumberError(String str){
        Verifications.verifyTextEquals(getPhoneNumberError(), str);
        UIActions.takeScreenshotToAllureReport();
    }

    private static void inputData(String title, String firstName, String lastName,
                           String email, String password,
                           String phone, String apartment,
                           String street, String town,
                           String state, String zip){
        UIActions.clickElement(registrationPage.getTitle());
        UIActions.selectOptionByValue(registrationPage.getTitle(), title);
        UIActions.sendKeysToElement(registrationPage.getFirstName(), firstName);
        UIActions.sendKeysToElement(registrationPage.getLastName(), lastName);
        UIActions.sendKeysToElement(registrationPage.getEmail(), email);
        UIActions.sendKeysToElement(registrationPage.getPassword(), password);
        UIActions.sendKeysToElement(registrationPage.getPhoneNumber(), phone);
        UIActions.sendKeysToElement(registrationPage.getApartment(), apartment);
        UIActions.sendKeysToElement(registrationPage.getStreet(), street);
        UIActions.sendKeysToElement(registrationPage.getTown(), town);
        UIActions.clickElement(registrationPage.getState());
        UIActions.selectOptionByValue(registrationPage.getState(), state);
        UIActions.sendKeysToElement(registrationPage.getZip(), zip);
        UIActions.clickElement(registrationPage.getSignUpButton());
    }

    private static String getFirstNameError(){
        return registrationPage.getFirstNameError().getText().toLowerCase();
    }

    private static String getLastNameError(){
        return registrationPage.getLastNameError().getText().toLowerCase();
    }

    private static String getEmailError(){
        return registrationPage.getEmailError().getText().toLowerCase();
    }

    private static String getPasswordError(){
        return registrationPage.getPasswordError().getText().toLowerCase();
    }

    private static String getPhoneNumberError(){
        return registrationPage.getPhoneNumberError().getText().toLowerCase();
    }
}
