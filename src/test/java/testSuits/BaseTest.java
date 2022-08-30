package testSuits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.WebBrowserType;
import utils.WebDriverUtils;

import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public WebDriver getWebDriver(){
        return driver;
    }

    public WebDriverWait getWebDriverWait(){
        return wait;
    }

    private void setDriver(WebBrowserType type){
        switch (type){
            case CHROME:
                driver = WebDriverUtils.createDriver(WebBrowserType.CHROME);
                break;
            case FIREFOX:
                driver = WebDriverUtils.createDriver(WebBrowserType.FIREFOX);
                break;
            case EDGE:
                driver = WebDriverUtils.createDriver(WebBrowserType.EDGE);
                break;
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Parameters({"browserType"})
    @BeforeClass
    public void baseTestSetUp(@Optional("CHROME") WebBrowserType type){
        try {
            setDriver(type);
        }catch (Exception e){
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
