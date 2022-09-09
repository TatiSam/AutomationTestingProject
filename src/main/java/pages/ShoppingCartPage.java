package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class ShoppingCartPage{

    @FindBy(css = "[class=\"itemNumber\"]")
    private WebElement itemNumber;

    @FindBy(css = "p[class=\"price\"]")
    private WebElement price;

    @FindBy(css = "[class=\"qtyColumn\"] a")
    private WebElement quantity;

    @FindBy(css = "[class=\"qtyColumn\"] ul li:nth-child(2) a")
    private WebElement changeQuantity;

    @FindBy(id = "sbtotals")
    private WebElement total;

    @FindBy(css = "a[title=\"Click to remove this item\"]")
    private WebElement remove;

    @FindBy(css = "[id=\"title\"] p")
    private WebElement message;

    public WebElement getItemNumber(){
        return itemNumber;
    }

    public WebElement getPrice(){
        return price;
    }

    public WebElement getQuantity(){
        return quantity;
    }

    public WebElement getChangeQuantity(){
        return changeQuantity;
    }

    public WebElement getTotal(){
        return total;
    }

    public WebElement getRemove(){
        return remove;
    }

    public WebElement getMessage(){
        return message;
    }
}
