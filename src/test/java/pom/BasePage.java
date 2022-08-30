package pom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return wait;
    }

    public void waitElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    public void waitElementLocated(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void hover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectDropDownByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectDropDownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void takeScreenshot(String filePath, String fileName){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy.HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String fName = fileName + "_" + dtf.format(now) + ".png";
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String path = filePath + fName;
            FileUtils.copyFile(file, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchNewOpenedWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
