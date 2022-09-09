package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class ListOfProductsPage{

    @FindBy(css = "[data-testid=\"plp-product-grid-item\"]:first-child h2 a")
    private WebElement firstResult;

    @FindBy(css = "[data-testid=\"plp-product-grid-item\"]:nth-child(2) h2 a")
    private WebElement secondResult;

    @FindBy(css = "[id=\"plp-results-title-container\"] h1 span:first-child")
    private WebElement plpResult;

    @FindBy(css = "[role=\"status\"]")
    private WebElement plpCountResults;

    @FindBy(css = "[data-testid=\"plp-product-grid-item\"]:first-child p>a>span")
    private WebElement firstResultPrice;

    public WebElement getFirstResult(){
        return firstResult;
    }

    public WebElement getSecondResult() {
        return secondResult;
    }

    public WebElement getPlpResult(){
        return plpResult;
    }

    public WebElement getPlpCountResults(){
        return plpCountResults;
    }
}
