package orangehrm.page;

import orangehrm.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    //private WebDriver driver;

    /* This locators are Page Object Model*/
    /*private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");*/

    /* Below are the WebElement located by @FindBy */
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement invalidCredentialMessage;


    /* Constructor */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /* Actions Method's */
    public void login(String userName, String pass) {
        waitForElement(username);
        username.sendKeys(userName);
        password.sendKeys(pass);
        loginButton.click();
    }


    public String verifyInvalidUsername() {
        waitForElement(username);
        try {
            return getText(invalidCredentialMessage);
        } catch (Exception e) {
            log.info("Unable to get text from field->", e.getMessage());
            return null;
        }

    }

}
