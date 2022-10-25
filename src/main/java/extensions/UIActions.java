package extensions;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.Variables.*;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class UIActions {
    @Step("Click web element")
    public static void clickElement(WebElement element) {
        element.click();
    }

    @Step("Select option: {1}")
    public static void selectOptionByValue(WebElement element, String val) {
        Select select = new Select(element);
        select.selectByValue(val);
    }

    @Step("Select option: {1}")
    public static void selectOptionByValue(Select select, String val) {
        select.selectByValue(val);
    }

    @Step("Hover over web element")
    public static void hoverOverElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    @Step("Send keys: {1} to element")
    public static void sendKeysToElement(WebElement webElement, String keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Step("Send RETURN Key")
    public static void sendReturnKey(WebElement webElement) {
        webElement.sendKeys(Keys.RETURN);
    }

    @Step("Wait web element located")
    public static void waitElementLocated(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Wait web element located")
    public static void waitElementLocated(Select select) {
        wait.until(ExpectedConditions.visibilityOf((WebElement) select));
    }

    @Step("Visit URL: {0}")
    public static void visit(String url) {
        driver.get(url);
    }

    @Step("Go back")
    public static void goBack() {
        driver.navigate().back();
    }

    @Step("Take screenshot")
    public static void takeScreenshot(String filePath){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy.HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        String fName = dtf.format(now) + ".png";
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String path = filePath + fName;
            FileUtils.copyFile(file, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Take screenshot")
    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenshotToAllureReport() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Switch new opened window")
    public static void switchNewOpenedWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
