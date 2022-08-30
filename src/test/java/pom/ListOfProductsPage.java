package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListOfProductsPage extends BasePage{
    @FindBy(css = "[data-testid=\"plp-product-grid-item\"]:first-child h2 a")
    private WebElement firstResultEl;

    @FindBy(css = "[id=\"plp-results-title-container\"] h1 span:first-child")
    private WebElement plpResultEl;

    @FindBy(css = "[role=\"status\"]")
    private WebElement plpCountResultsEl;

    @FindBy(css = "[data-testid=\"plp-product-grid-item\"]:first-child p>a>span")
    private WebElement firstResultPriceEl;

    public ListOfProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getPlpResult(){
        waitElementLocated(plpResultEl);
        return plpResultEl.getText().toLowerCase();
    }

    public int getPlpCountResults(){
        waitElementLocated(plpCountResultsEl);
        return Integer.parseInt(plpCountResultsEl.getText().split(" ")[0]);
    }

    public String getFirstResultName(){
        waitElementLocated(firstResultEl);
        return firstResultEl.getText().toLowerCase();
    }

    public String getFirstResultPrice(){
        waitElementLocated(firstResultPriceEl);
        return firstResultPriceEl.getText();
    }

    @Step("Verify plp result is equal to {0}")
    public boolean verifyPlpResult(String str){
        return getPlpResult().contains(str);
    }

    @Step("Verify plp count results is greater than {0}")
    public boolean verifyPlpCountResults(int min){
        return getPlpCountResults() > min;
    }

    @Step("Verify first result name contains {0}")
    public boolean verifyFirstResultName(String str){
        return getFirstResultName().contains(str);
    }

    @Step("Clicking on first result")
    public ProductPage clickOnFirstResult(){
        waitElementLocated(firstResultEl);
        firstResultEl.click();
        return new ProductPage(getWebDriver(), getWebDriverWait());
    }
}
