package orangehrm.tests;

import orangehrm.base.TestBase;
import orangehrm.page.DashboardPage;
import orangehrm.page.LoginPage;
import orangehrm.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void initializationSetup(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void verifyDashBoardPage() {
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        dashboardPage.verifyDashboardPage();
        dashboardPage.verifyQuickLaunchOptions();
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }
}
