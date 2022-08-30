package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private final String url = "https://www.next.co.il/en";

    @FindBy(css = "[data-testid=\"country-selector-close-button\"]")
    private WebElement countrySelectorCloseBtnEl;

    @FindBy(css = "[title=\"GIRLS\"]")
    private WebElement navBarGirlsLinkEl;

    @FindBy(css = "[title=\"Jeans\"]")
    private WebElement navBarJeansLinkEl;

    @FindBy(css = "button[data-ga-v2=\"Shopping bag\"]")
    private WebElement shoppingBagBtnEl;

    @FindBy(css = "[data-ga-v3=\"View Bag\"]")
    private WebElement viewBagBtnEl;

    @FindBy(css = "[id=\"header-search-form\"] input")
    private WebElement searchBoxEl;

    @FindBy(css = "[id=\"header-search-form\"] button")
    private WebElement searchBtnEl;

    @FindBy(css = "[data-testid=\"header-adaptive-my-account-icon-container-link\"]")
    private WebElement myAccountBtnEl;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
        visit(url);
    }

    @Step("Finding product")
    public ListOfProductsPage findProduct(){
        waitElementLocated(navBarGirlsLinkEl);
        hover(navBarGirlsLinkEl);
        waitElementLocated(navBarJeansLinkEl);
        navBarJeansLinkEl.click();
        return new ListOfProductsPage(getWebDriver(), getWebDriverWait());
    }

    @Step("Clicking on Shopping Cart")
    public ShoppingCartPage clickOnShoppingCart(){
        waitElementLocated(shoppingBagBtnEl);
        shoppingBagBtnEl.click();
        waitElementLocated(viewBagBtnEl);
        viewBagBtnEl.click();
        return new ShoppingCartPage(getWebDriver(), getWebDriverWait());
    }

    @Step("Inserting term {0} to search box")
    public void insertTermToSearchBox(String term){
        //closeCountrySelectorPopUp();
        waitElementLocated(searchBoxEl);
        searchBoxEl.sendKeys(term);
    }

    @Step("Clicking on Search button")
    public void clickSearchButton(){
        waitElementLocated(searchBoxEl);
        searchBtnEl.click();
    }

    @Step("Clicking on My Account button")
    public LoginPage clickOnMyAccountBtn() {
        waitElementLocated(myAccountBtnEl);
        myAccountBtnEl.click();
        return new LoginPage(getWebDriver(), getWebDriverWait());
    }

    @Step("Closing Country Selector pop-up")
    public void closeCountrySelectorPopUp(){
        try {
            countrySelectorCloseBtnEl.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    @Step("Search term {0}")
    public ListOfProductsPage search(String term){
        insertTermToSearchBox(term);
        clickSearchButton();
        return new ListOfProductsPage(getWebDriver(), getWebDriverWait());
    }
}
