package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class HomePage {
    @FindBy(css = "[title=\"GIRLS\"]")
    private WebElement navBarGirlsLink;

    @FindBy(css = "[title=\"Jeans\"]")
    private WebElement navBarJeansLink;

    @FindBy(css = "[id=\"header-search-form\"] input")
    private WebElement searchBox;

    @FindBy(css = "[id=\"header-search-form\"] button")
    private WebElement searchButton;

    @FindBy(css = "[data-testid=\"header-adaptive-my-account-icon-container-link\"]")
    private WebElement myAccountButton;

    public WebElement getNavBarGirlsLink(){
        return navBarGirlsLink;
    }

    public WebElement getNavBarJeansLink(){
        return navBarJeansLink;
    }

    public WebElement getSearchBox(){
        return searchBox;
    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public WebElement getMyAccountButton(){
        return myAccountButton;
    }
}
