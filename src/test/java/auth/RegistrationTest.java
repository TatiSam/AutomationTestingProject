package auth;

import base.BaseTest;
import extensions.UIActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import utilities.ManageDDT;
import utilities.TestListener;
import workFlows.RegistrationWorkFlows;

import static utilities.Variables.*;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
@Listeners({TestListener.class})
public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void setUpTest(){
        UIActions.visit(url);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify registration successful")
    @Test(
            dataProvider = "validDataRegistration",
            dataProviderClass = ManageDDT.class,
            description = "Test registration successful"
    )
    public void test01_registration(String title, String fName, String lName,
                                      String email, String password,
                                      String phone, String apartment,
                                      String street, String town,
                                      String state, String zip){
        RegistrationWorkFlows.register(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        RegistrationWorkFlows.verifyRegistration();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify registration failed with first name invalid")
    @Test(
            dataProvider = "firstNameInvalidRegistration",
            dataProviderClass = ManageDDT.class,
            description = "Test registration failed with first name invalid"
    )
    public void test02_registration(String title, String fName, String lName,
                                             String email, String password,
                                             String phone, String apartment,
                                             String street, String town,
                                             String state, String zip, String expectedResult){
        RegistrationWorkFlows.register(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        RegistrationWorkFlows.verifyFirstNameError(expectedResult);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify registration failed with last name invalid")
    @Test(
            dataProvider = "lastNameInvalidRegistration",
            dataProviderClass = ManageDDT.class,
            description = "Test registration failed with last name invalid"
    )
    public void test03_registration(String title, String fName, String lName,
                                            String email, String password,
                                            String phone, String apartment,
                                            String street, String town,
                                            String state, String zip, String expectedResult){
        RegistrationWorkFlows.register(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        RegistrationWorkFlows.verifyLastNameError(expectedResult);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify registration failed with email invalid")
    @Test(
            dataProvider = "emailInvalidRegistration",
            dataProviderClass = ManageDDT.class,
            description = "Test registration failed with email invalid"
    )
    public void test04_registration(String title, String fName, String lName,
                                         String email, String password,
                                         String phone, String apartment,
                                         String street, String town,
                                         String state, String zip, String expectedResult){
        RegistrationWorkFlows.register(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        RegistrationWorkFlows.verifyEmailError(expectedResult);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify registration failed with password invalid")
    @Test(
            dataProvider = "passwordInvalidRegistration",
            dataProviderClass = ManageDDT.class,
            description = "Test registration failed with password invalid"
    )
    public void test05_registration(String title, String fName, String lName,
                                            String email, String password,
                                            String phone, String apartment,
                                            String street, String town,
                                            String state, String zip, String expectedResult){
        RegistrationWorkFlows.register(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        RegistrationWorkFlows.verifyPasswordError(expectedResult);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify registration failed with phone number invalid")
    @Test(
            dataProvider = "phoneNumberInvalidRegistration",
            dataProviderClass = ManageDDT.class,
            description = "Test registration failed with phone number invalid"
    )
    public void test06_registration(String title, String fName, String lName,
                                               String email, String password,
                                               String phone, String apartment,
                                               String street, String town,
                                               String state, String zip, String expectedResult){
        RegistrationWorkFlows.register(title, fName, lName, email,
                password, phone, apartment, street, town, state, zip);
        RegistrationWorkFlows.verifyPhoneNumberError(expectedResult);
    }
}
