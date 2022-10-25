package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ManagePages;
import utilities.WebBrowserType;

import java.time.Duration;

import static utilities.Variables.*;

/**
 * @author Tatiana Samoilenko, Sep 2022
 * @project QA-Automation next.co.il
 */
public class BaseTest {
    @BeforeClass
    @Parameters({"BrowserType", "URL", "Timeout"})
    public void setUp(@Optional(value = "CHROME") String BrowserType,
                             @Optional(value = "https://www.next.co.il/en") String URL,
                             @Optional(value = "5") String Timeout){
        browserType = WebBrowserType.valueOf(BrowserType);
        url = URL;
        timeout = Timeout;
        searchTerm = "jeans";
        initWeb();
        initDataFilePath();
        initScreenFilePath();
        initExpectedResults();
    }

    @Step("Initialization web")
    private void initWeb() {
        switch(browserType) {
            case CHROME:
                initChromeDriver();
                break;
            case FIREFOX:
                initFirefoxDriver();
                break;
            case EDGE:
                initEdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Type");
        }
        driver.manage().window().maximize();
        setDriverTimeoutAndWait();
        actions = new Actions(driver);
        ManagePages.initPages();
        driver.get(url);
    }

    private void initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
    }

    private void initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    private void setDriverTimeoutAndWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(timeout)));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
    }

    private void initDataFilePath(){
        registrationDataFilePath = ".\\files\\next-registration.xlsx";
        searchDataFilePath = ".\\files\\next-search.xlsx";
    }

    private void initScreenFilePath(){
        screenLoginFilePath = ".\\assets\\register\\";
        screenRegistrationFilePath = ".\\assets\\login\\";
        screenSearchFilePath = ".\\assets\\search\\";
        screenShoppingCartFilePath = ".\\assets\\shopping\\";
    }

    private void initExpectedResults(){
        shoppingCartMsg1item = "your bag contains 1 item";
        shoppingCartMsg2items = "your bag contains 2 items";
        shoppingCartEmptyMsg = "your bag contains 0 item and comes to a total of ₪ 0.00.";
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
