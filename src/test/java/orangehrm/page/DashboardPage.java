package orangehrm.page;

import orangehrm.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class DashboardPage extends TestBase {

    /* String Locator */
    private static final String QUICK_LAUNCH_MENUS_XPATH1 = "//button[@title='";
    private static final String QUICK_LAUNCH_MENUS_XPATH2 = "']";

    /* Locators */
    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardPageHeader;

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu;

    @FindBy(xpath = "//nav[@aria-label='Sidepanel']")
    private WebElement sidePanel;

    @FindBy(xpath = "//p[text()='Time at Work']/ancestor::div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']")
    private WebElement timeAtWorkWidget;

    @FindBy(xpath = "//p[text()='My Actions']/ancestor::div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']")
    private WebElement myActionsWidget;

    @FindBy (xpath = "//p[text()='Quick Launch']/ancestor::div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']")
    private WebElement quickLaunchWidget;

    @FindBy (xpath = "//p[text()='Buzz Latest Posts']/ancestor::div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']")
    private WebElement buzzLatestPostsWidget;

    @FindBy (xpath = "//p[text()='Employees on Leave Today']/ancestor::div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget emp-leave-chart']")
    private WebElement employeesOnLeaveTodayWidget;

    @FindBy (xpath = "//p[text()='Employee Distribution by Sub Unit']/ancestor::div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']")
    private WebElement employeeDistributionBySubUnitWidget;

    //Employee Distribution by Location
    @FindBy(xpath = "//p[text()='Employee Distribution by Location']/ancestor::div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']")
    private WebElement EmployeeDistributionByLocationWidget;


    /* Constructor */
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* Action Method's */

    public void verifyDashboardPage() {
        waitForElement(dashboardPageHeader);
        try {
            Thread.sleep(5000);
            Assert.assertTrue(elementVisibility(dashboardPageHeader));
            Assert.assertTrue(sidePanel.isDisplayed());
            log.info("Dashboard is Opened successfully");
        } catch (Exception e) {
            System.out.println("Dashboard is no visible " + e.getMessage());
        }

    }


    public void verifyQuickLaunchOptions(){
        List<String> quickLaunchMenuList = Arrays.asList("Assign Leave", "Leave List", "Timesheets", "Apply Leave", "My Leave", "My Timesheet");
        try {
            for (String menu :quickLaunchMenuList){
                WebElement option = driver.findElement(
                        By.xpath(QUICK_LAUNCH_MENUS_XPATH1 + menu + QUICK_LAUNCH_MENUS_XPATH2));
                waitForElement(option);
                log.info("Option is present : " + option.getText());
            }

        } catch(Exception e){
            Assert.fail("Unable to verify options from Quick Launch Options");
        }
    }

}
