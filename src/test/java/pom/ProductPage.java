package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
    @FindBy(css = "[class=\"StyleCopy \"] [class=\"DropDown\"]:nth-child(3)>div a")
    private WebElement chooseSizeEl;

    @FindBy(css = "li[class=\"InStock\"] a[class=\"dk_dropdown_option\"]")
    private WebElement firstSizeEl;

    @FindBy(css = "[class=\"AddToBag\"] a")
    private WebElement addToBagBtnEl;

    @FindBy(css = "[data-ga-v3=\"View Bag\"]")
    private WebElement viewBagBtnEl;

    @FindBy(css = "button[data-ga-v2=\"Shopping bag\"]")
    private WebElement shoppingBagBtnEl;

    @FindBy(css = "[class=\"ItemNumber\"]")
    private WebElement itemNumberEl;

    @FindBy(css = "[class=\"nowPrice\"]>span")
    private WebElement priceEl;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getPrice(){
        waitElementLocated(priceEl);
        return priceEl.getText();
    }

    public String getItemNumber(){
        waitElementLocated(viewBagBtnEl);
        return itemNumberEl.getText();
    }

    @Step("Choose size of product")
    public void chooseSize(){
        waitElementLocated(chooseSizeEl);
        chooseSizeEl.click();
        waitElementLocated(firstSizeEl);
        firstSizeEl.click();
    }

    @Step("Clicking on Add To Bag button")
    public void clickOnAddToBagBtn(){
        waitElementLocated(addToBagBtnEl);
        addToBagBtnEl.click();
    }

    @Step("Clicking on Shopping Bag button")
    public void clickOnShoppingBagBtn(){
        waitElementLocated(shoppingBagBtnEl);
        shoppingBagBtnEl.click();
    }

    @Step("Clicking on View Bag button")
    public void clickOnViewBagBtn(){
        waitElementLocated(viewBagBtnEl);
        viewBagBtnEl.click();
    }

    @Step("Putting product to shopping cart")
    public String putProductToShoppingCart(){
        chooseSize();
        clickOnAddToBagBtn();
        return getItemNumber();
    }

    @Step("Going to shopping cart")
    public ShoppingCartPage goToShoppingCart(){
        clickOnShoppingBagBtn();
        clickOnViewBagBtn();
        return new ShoppingCartPage(getWebDriver(), getWebDriverWait());
    }

    @Step("Verify price of product is equal to {0}")
    public boolean verifyPrice(String price){
        return getPrice().equals(price);
    }
}
