package auth;

import base.BaseTest;
import extensions.UIActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import utilities.ManageDDT;
import utilities.TestListener;
import utilities.Variables;
import workFlows.LoginWorkFlows;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
@Listeners({TestListener.class})
public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUpTest(){
        UIActions.visit(Variables.url);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login successful")
    @Test(
            dataProvider = "correctDataLogin",
            dataProviderClass = ManageDDT.class,
            description = "Test login successful"
    )
    public void test01_login(String email, String password) {
        LoginWorkFlows.login(email, password);
        LoginWorkFlows.verifyLogin();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login failed")
    @Test(
            dataProvider = "incorrectDataLogin",
            dataProviderClass = ManageDDT.class,
            description = "Test login failed"
    )
    public void test02_login(String email, String password){
        LoginWorkFlows.login(email, password);
        LoginWorkFlows.verifyLogin();
    }
}
