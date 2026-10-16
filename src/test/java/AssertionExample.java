import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AssertionExample {

    private static final Logger log = LoggerFactory.getLogger(AssertionExample.class);
    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
    }


    @Test(priority = 1)
    public void logoTest(){
        WebElement companylogo = driver.findElement(By.cssSelector("img[alt=company-branding]"));
        Assert.assertTrue(companylogo.isDisplayed(), "logo is not displayed");
        log.info("Company logo verified");
    }

    @Test(priority = 2)
    public void homePageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM", title, "Title is not correct");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        log.info("chrome is closed successfully.");
    }

}
