package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class ProductPage{

    @FindBy(css = "div[class=\"DropDown\"][style=\"display:block\"] a")
    private WebElement chooseSize;

    @FindBy(css = "li[class=\"InStock\"] a[class=\"dk_dropdown_option\"]")
    private WebElement firstSize;

    @FindBy(css = "[class=\"AddToBag\"] a")
    private WebElement addToBagButton;

    @FindBy(css = "[data-ga-v3=\"View Bag\"]")
    private WebElement viewBagButton;

    @FindBy(css = "button[data-ga-v2=\"Shopping bag\"]")
    private WebElement shoppingBagButton;

    public WebElement getViewBagButton(){
        return viewBagButton;
    }

    public WebElement getShoppingBagButton(){
        return shoppingBagButton;
    }

    public WebElement getChooseSize(){
        return chooseSize;
    }

    public WebElement getFirstSize(){
        return firstSize;
    }

    public WebElement getAddToBagButton(){
        return addToBagButton;
    }
}
