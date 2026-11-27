package orangehrm.tests;

import orangehrm.base.TestBase;
import orangehrm.page.DashboardPage;
import orangehrm.page.LoginPage;
import orangehrm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void initializeLoginPage() {
        // TestBase.setUp() runs first and creates the driver for this test.
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 1)
    public void validLogin() {
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
        log.info("Login is successful.");
    }

    @Test(priority = 2)
    public void invalidUsername() {
        //Wrong Username & Correct password
        loginPage.login("Test123", "admin123");
        Assert.assertEquals(
                loginPage.verifyInvalidUsername(),
                "Invalid credentials",
                "Invalid Credentials message is not present when entered wrong username.");

    }

    @Test(priority = 3)
    public void invalidPassword() {
        //correct username & wrong password
        loginPage.login(ConfigReader.get("username"), "admin225");
        Assert.assertEquals(
                loginPage.verifyInvalidUsername(),
                "Invalid credentials",
                "Invalid Credentials message is not present when entered wrong password.");

    }

    @Test(priority = 4)
    public void invalidUserNameAndPassword() {
        //Wrong username & Wrong Password
        loginPage.login("Test123", "aadmin123");
        Assert.assertEquals(
                loginPage.verifyInvalidUsername(),
                "Invalid credentials",
                "Invalid Credentials message is not present when entered wrong username & password.");
    }

}

