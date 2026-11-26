package TestNG_Practice.SelfHealingLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Use_SelfHealingLocator {


    public void clickLoginButton(WebDriver driver) {
        SelfHealingLocator selfHealingLocator = new SelfHealingLocator();

        // Put the preferred XPath first, then fallback XPaths in priority order.
        WebElement loginButton = selfHealingLocator.findElementWithRetry(
                driver,
                "//button[@id='login-button']",
                new String[]{
                        "//button[@type='submit']",
                        "//button[contains(normalize-space(), 'Login')]"
                }
        );

        loginButton.click();
    }
}
