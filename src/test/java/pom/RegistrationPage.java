package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{
    private final String filePathToScreenshots =
            "C:\\Users\\Den_PC\\Desktop\\ness\\Selenium\\Projects\\nextProject\\assets\\register\\";

    private WebElement titleEl;
    private WebElement stateEl;

    @FindBy(id = "FirstName")
    private WebElement firstNameEl;

    @FindBy(id = "LastName")
    private WebElement lastNameEl;

    @FindBy(id = "Email")
    private WebElement emailEl;

    @FindBy(id = "Password")
    private WebElement passwordEl;

    @FindBy(id = "PhoneNumber")
    private WebElement phoneNumberEl;

    @FindBy(id = "AddressLine1")
    private WebElement apartmentEl;

    @FindBy(id = "AddressLine2")
    private WebElement streetEl;

    @FindBy(id = "AddressLine4")
    private WebElement townEl;

    @FindBy(id = "AddressLine6")
    private WebElement zipEl;

    @FindBy(id = "SignupButton")
    private WebElement signUpBtnEl;

    @FindBy(css = "div[class=\"error-description\"] a[class=\"link-btn\"]")
    private WebElement continueShoppingBtnEl;

    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorEl;

    @FindBy(id = "LastName-error")
    private WebElement lastNameErrorEl;

    @FindBy(id = "Email-error")
    private WebElement emailErrorEl;

    @FindBy(id = "Password-error")
    private WebElement passwordErrorEl;

    @FindBy(id = "PhoneNumber-error")
    private WebElement phoneNumberErrorEl;

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(getWebDriver(), this);
    }

    private void findTitleEl(String title){
        By titleSelector = By.cssSelector("[id=\"Title\"] [value=\"" + title + "\"]");
        titleEl = findElement(titleSelector);
    }

    private void findStateEl(String state){
        By stateSelector = By.cssSelector("[id=\"AddressLine5\"] [value=\"" + state + "\"]");
        waitElementLocated(stateSelector);
        stateEl = findElement(stateSelector);
    }

    private void insertData(String title, String firstName, String lastName,
                            String email, String password,
                            String phone, String apartment,
                            String street, String town,
                            String state, String zip){
        checkTitle(title);
        insertFirstName(firstName);
        insertLastName(lastName);
        insertEmail(email);
        insertPassword(password);
        insertPhoneNumber(phone);
        insertApartment(apartment);
        insertStreet(street);
        insertTown(town);
        checkState(state);
        insertZip(zip);
        clickOnSignUp();
    }

    @Step("Checking title: {0}")
    public void checkTitle(String title){
        findTitleEl(title);
        titleEl.click();
    }

    @Step("Inserting first name: {0}")
    public void insertFirstName(String firstName){
        firstNameEl.sendKeys(firstName);
    }

    @Step("Inserting last name: {0}")
    public void insertLastName(String lastName){
        lastNameEl.sendKeys(lastName);
    }

    @Step("Inserting email: {0}")
    public void insertEmail(String email){
        emailEl.sendKeys(email);
    }

    @Step("Inserting password: {0}")
    public void insertPassword(String password){
        passwordEl.sendKeys(password);
    }

    @Step("Inserting phone number: {0}")
    public void insertPhoneNumber(String phone){
        phoneNumberEl.sendKeys(phone);
    }

    @Step("Inserting apartment: {0}")
    public void insertApartment(String apartment){
        apartmentEl.sendKeys(apartment);
    }

    @Step("Inserting street: {0}")
    public void insertStreet(String street){
        streetEl.sendKeys(street);
    }

    @Step("Inserting town: {0}")
    public void insertTown(String town){
        townEl.sendKeys(town);
    }

    @Step("Checking state: {0}")
    public void checkState(String state){
        findStateEl(state);
        stateEl.click();
    }

    @Step("Inserting zip: {0}")
    public void insertZip(String zip){
        zipEl.sendKeys(zip);
    }

    @Step("Clicking on Sign Up button")
    public void clickOnSignUp(){
        signUpBtnEl.click();
    }

    @Step("Registration with valid data")
    public String registerWithValidData(String title, String firstName, String lastName,
                                        String email, String password,
                                        String phone, String apartment,
                                        String street, String town,
                                        String state, String zip){
        insertData(title, firstName, lastName, email, password, phone, apartment, street,
                town, state, zip);
        String fileName = "valid_data\\valid_data";
        takeScreenshot(filePathToScreenshots, fileName);
        return continueShoppingBtnEl.getText().toLowerCase();
    }

    @Step("Registration with first name invalid")
    public String registerWithFirstNameInvalid(String title, String firstName, String lastName,
                                        String email, String password, String phone, String apartment,
                                        String street, String town,
                                        String state, String zip){
        insertData(title, firstName, lastName, email, password, phone, apartment, street,
                town, state, zip);
        String fileName = "firstname_invalid\\firstname_invalid";
        takeScreenshot(filePathToScreenshots, fileName);
        return firstNameErrorEl.getText().toLowerCase();
    }

    @Step("Registration with last name invalid")
    public String registerWithLastNameInvalid(String title, String firstName, String lastName,
                                               String email, String password,
                                               String phone, String apartment,
                                               String street, String town,
                                               String state, String zip){
        insertData(title, firstName, lastName, email, password, phone, apartment, street,
                town, state, zip);
        String fileName = "lastname_invalid\\lastname_invalid";
        takeScreenshot(filePathToScreenshots, fileName);
        return lastNameErrorEl.getText().toLowerCase();
    }

    @Step("Registration with email invalid")
    public String registerWithEmailInvalid(String title, String firstName, String lastName,
                                              String email, String password,
                                              String phone, String apartment,
                                              String street, String town,
                                              String state, String zip){
        insertData(title, firstName, lastName, email, password, phone, apartment, street,
                town, state, zip);
        String fileName = "email_invalid\\email_invalid";
        takeScreenshot(filePathToScreenshots, fileName);
        return emailErrorEl.getText().toLowerCase();
    }

    @Step("Registration with password invalid")
    public String registerWithPasswordInvalid(String title, String firstName, String lastName,
                                           String email, String password,
                                           String phone, String apartment,
                                           String street, String town,
                                           String state, String zip){
        insertData(title, firstName, lastName, email, password, phone, apartment, street,
                town, state, zip);
        String fileName = "password_invalid\\password_invalid";
        takeScreenshot(filePathToScreenshots, fileName);
        return passwordErrorEl.getText().toLowerCase();
    }

    @Step("Registration with phone number invalid")
    public String registerWithPhoneNumberInvalid(String title, String firstName, String lastName,
                                              String email, String password,
                                              String phone, String apartment,
                                              String street, String town,
                                              String state, String zip){
        insertData(title, firstName, lastName, email, password, phone, apartment, street,
                town, state, zip);
        String fileName = "phone_invalid\\phone_invalid";
        takeScreenshot(filePathToScreenshots, fileName);
        return phoneNumberErrorEl.getText().toLowerCase();
    }
}
