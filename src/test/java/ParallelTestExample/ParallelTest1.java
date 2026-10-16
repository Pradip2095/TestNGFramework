package ParallelTestExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ParallelTest1 {

    WebDriver driver = new ChromeDriver();

    @Test
    public void logoTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        WebElement logo = driver.findElement(By.xpath("//div//img[@alt ='company-branding']"));
        Assert.assertTrue(logo.isDisplayed(), "logo not displayed.");
        Thread.sleep(5000);
    }

    @Test
    public void homePageTitle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String pageTitle = driver.getTitle();
        Assert.assertEquals("OrangeHRM", pageTitle, "Title not match.");
        Thread.sleep(5000);
        driver.close();
    }

}
