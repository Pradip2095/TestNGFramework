import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ParametersExample {

    private static final Logger log = LoggerFactory.getLogger(AssertionExample.class);
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setup(String browser, String app) throws InterruptedException {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.get(app);
        Thread.sleep(5000);
    }


    @Test(priority = 1)
    public void logoTest() {
        WebElement companylogo = driver.findElement(By.cssSelector("img[alt=company-branding]"));
        Assert.assertTrue(companylogo.isDisplayed(), "logo is not displayed");
        log.info("Company logo verified");
    }

    @Test(priority = 2)
    public void homePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM", title, "Title is not correct");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("browser is quited successfully.");
    }

}
