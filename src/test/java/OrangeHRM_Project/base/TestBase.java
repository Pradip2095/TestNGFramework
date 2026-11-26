package OrangeHRM_Project.base;

import OrangeHRM_Project.utils.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;


public class TestBase {

    protected WebDriver driver;

    public static final Logger log = LoggerFactory.getLogger(TestBase.class);
    private static WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.get("browser");
        //driver = browser.equalsIgnoreCase("edge") ? new EdgeDriver() : new ChromeDriver();

        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(ConfigReader.get("disableChromePasswordWarning"))) {
                options.addArguments("--disable-features=PasswordLeakDetection");
            }

            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }


    /* Wait For Visibility Of Element */
    public boolean waitForElement(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("WebElement is available now" + element);
            return true;
        } catch (Exception e) {
            log.info("Does not become available");
            return false;
        }
    }


    /* Element Visibility */
    public static boolean elementVisibility(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            log.info("{} unable to check the visibility of element", element);
            Assert.fail("Unable to check the visibility of element" + element + e.getMessage());
            return false;
        }
    }

    /* get text from Input field */
    public String getText(WebElement element) {
        try {
            waitForElement(element);
            String value = element.getText();
            return value;

        } catch (Exception e) {
            Assert.fail("Unable to get text " + element.getText());
            return null;
        }

    }
}
