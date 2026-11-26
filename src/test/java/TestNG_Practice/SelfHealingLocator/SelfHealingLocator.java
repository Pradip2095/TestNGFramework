package TestNG_Practice.SelfHealingLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** Finds an element with a primary XPath and falls back to alternate XPaths. */
public class SelfHealingLocator {

    /**
     * First tries {@code primaryLocator}. If that lookup fails, tries each
     * locator in {@code alternativeLocators} until one finds an element.
     *
     * @param driver Selenium WebDriver for the current browser
     * @param primaryLocator XPath for the preferred element
     * @param alternativeLocators fallback XPaths, tried in order
     * @return the element found by the primary or an alternate locator
     * @throws NoSuchElementException if no locator finds the element
     */
    public WebElement findElementWithRetry(
            WebDriver driver,
            String primaryLocator,
            String[] alternativeLocators) {

        if (driver == null) {
            throw new IllegalArgumentException("driver must not be null");
        }
        if (primaryLocator == null || primaryLocator.isBlank()) {
            throw new IllegalArgumentException("primaryLocator must not be blank");
        }
        if (alternativeLocators == null) {
            throw new IllegalArgumentException("alternativeLocators must not be null");
        }

        // First try the primary locator.
        try {
            return driver.findElement(By.xpath(primaryLocator));
        } catch (NoSuchElementException primaryException) {
            System.out.println(primaryLocator
                    + " - Primary locator failed; trying alternate locators.");
        }

        // If the primary locator failed, try each alternate locator in order.
        NoSuchElementException lastFailure = null;
        for (String alternateLocator : alternativeLocators) {
            if (alternateLocator == null || alternateLocator.isBlank()) {
                System.err.println("Skipping an empty alternate locator.");
                continue;
            }

            try {
                WebElement element = driver.findElement(By.xpath(alternateLocator));
                System.out.println(alternateLocator
                        + " - Alternate locator worked. Update the primary locator to this XPath.");
                return element;
            } catch (NoSuchElementException exception) {
                lastFailure = exception;
                System.err.println(alternateLocator + " - Alternate locator failed.");
            }
        }

        // Nothing matched, so report that all locator options failed.
        throw new NoSuchElementException(
                "Element was not found using the primary locator or any alternate locator.",
                lastFailure);
    }
}
