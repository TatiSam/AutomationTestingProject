package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage{
    private final String filePathToScreenshots =
            "C:\\Users\\Den_PC\\Desktop\\ness\\Selenium\\Projects\\nextProject\\assets\\shopping_cart\\";

    @FindBy(css = "[class=\"itemNumber\"]")
    private WebElement itemNumberEl;

    @FindBy(css = "p[class=\"price\"]")
    private WebElement priceEl;

    @FindBy(css = "[class=\"qtyColumn\"] a")
    private WebElement quantityEl;

    @FindBy(css = "[class=\"qtyColumn\"] ul li:nth-child(2) a")
    private WebElement changeQuantityEl;

    @FindBy(id = "sbtotals")
    private WebElement totalEl;

    @FindBy(css = "a[title=\"Click to remove this item\"]")
    private WebElement removeProductEl;

    @FindBy(css = "[id=\"title\"] p")
    private WebElement msgEl;

    @FindBy(className = "shopmore")
    private WebElement shopMoreEl;

    public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public double getPriceOfProduct(){
        waitElementLocated(priceEl);
        String price = priceEl.getText().substring(1);
        String fileName = "price\\price";
        takeScreenshot(filePathToScreenshots, fileName);
        return Double.parseDouble(price);
    }

    public String getItemNumber(){
        waitElementLocated(itemNumberEl);
        String fileName = "item_number\\item_number";
        takeScreenshot(filePathToScreenshots, fileName);
        return itemNumberEl.getText();
    }

    public int getCountOfProducts(){
        waitElementLocated(quantityEl);
        String fileName = "count\\count";
        takeScreenshot(filePathToScreenshots, fileName);
        return Integer.parseInt(quantityEl.getText());
    }

    public double getTotalSum() {
        waitElementLocated(totalEl);
        String total = totalEl.getText().substring(1);
        String fileName = "total\\total";
        takeScreenshot(filePathToScreenshots, fileName);
        return Double.parseDouble(total);
    }

    public String getMessage(){
        waitElementLocated(msgEl);
        String fileName = "message\\message";
        takeScreenshot(filePathToScreenshots, fileName);
        return msgEl.getText().toLowerCase();
    }

    @Step("Clicking on Quantity button")
    public void clickOnQuantity(){
        waitElementLocated(quantityEl);
        quantityEl.click();
    }

    @Step("Clicking on Change Quantity button")
    public void clickOnChangeQuantity(){
        waitElementLocated(changeQuantityEl);
        changeQuantityEl.click();
    }

    @Step("Clicking on Remove Product button")
    public void clickOnRemoveProduct(){
        waitElementLocated(removeProductEl);
        removeProductEl.click();
    }

    @Step("Clicking on Shop More button")
    public void clickOnShopMoreBtn(){
        waitElementLocated(shopMoreEl);
        shopMoreEl.click();
    }

    @Step("Changing count of product in shopping cart")
    public void changeCountOfProducts(){
        clickOnQuantity();
        clickOnChangeQuantity();
        String fileName = "change_quantity\\change_quantity";
        takeScreenshot(filePathToScreenshots, fileName);
    }

    @Step("Removing product from shopping cart")
    public void removeProduct() {
        clickOnRemoveProduct();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String fileName = "remove\\remove";
        takeScreenshot(filePathToScreenshots, fileName);
    }

    @Step("Verify item number is equal to {0}")
    public boolean verifyItemNumber(String itemNumber){
        return getItemNumber().equals(itemNumber);
    }

    @Step("Verify count of product is equal to {0}")
    public boolean verifyCountOfProduct(int count){
        return getCountOfProducts() == count;
    }

    @Step("Verify total sum is equal to {0}")
    public boolean verifyTotalSum(double total){
        return getTotalSum() == total;
    }

    @Step("Verify message is equal to {0}")
    public boolean verifyMessage(String msg){
        System.out.println(getMessage());
        return getMessage().equals(msg);
    }

    @Step("Exit from shopping cart")
    public void exitFromShoppingCart() {
        clickOnShopMoreBtn();
    }
}
