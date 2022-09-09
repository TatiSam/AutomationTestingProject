package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class RegistrationPage{

    @FindBy(id="Title")
    private WebElement title;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "PhoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "AddressLine1")
    private WebElement apartment;

    @FindBy(id = "AddressLine2")
    private WebElement street;

    @FindBy(id = "AddressLine4")
    private WebElement town;

    @FindBy(id="AddressLine5")
    private WebElement state;

    @FindBy(id = "AddressLine6")
    private WebElement zip;

    @FindBy(id = "SignupButton")
    private WebElement signUpButton;

    @FindBy(css = "div[class=\"error-description\"] a[class=\"link-btn\"]")
    private WebElement continueShoppingButton;

    @FindBy(id = "FirstName-error")
    private WebElement firstNameError;

    @FindBy(id = "LastName-error")
    private WebElement lastNameError;

    @FindBy(id = "Email-error")
    private WebElement emailError;

    @FindBy(id = "Password-error")
    private WebElement passwordError;

    @FindBy(id = "PhoneNumber-error")
    private WebElement phoneNumberError;

    public WebElement getTitle(){
        return title;
    }

    public WebElement getFirstName(){
        return firstName;
    }

    public WebElement getLastName(){
        return lastName;
    }

    public WebElement getEmail(){
        return email;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getPhoneNumber(){
        return phoneNumber;
    }

    public WebElement getApartment(){
        return apartment;
    }

    public WebElement getStreet(){
        return street;
    }

    public WebElement getTown(){
        return town;
    }

    public WebElement getState(){
        return state;
    }

    public WebElement getZip(){
        return zip;
    }

    public WebElement getSignUpButton(){
        return signUpButton;
    }

    public WebElement getContinueShoppingButton(){
        return continueShoppingButton;
    }

    public WebElement getFirstNameError(){
        return firstNameError;
    }

    public WebElement getLastNameError(){
        return lastNameError;
    }

    public WebElement getEmailError(){
        return emailError;
    }

    public WebElement getPasswordError(){
        return passwordError;
    }

    public WebElement getPhoneNumberError(){
        return phoneNumberError;
    }
}
