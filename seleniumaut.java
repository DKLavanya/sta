package seleniumautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class seleniumaut {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-infobars", "--start-maximized"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.in");

        // Search for iPhone 13
        wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox"))).sendKeys("Iphone 13", Keys.ENTER);

        // Find product with exact title "Apple iPhone 13 (128GB) - Blue"
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")));

        for (WebElement product : products) {
            if (product.getText().trim().equalsIgnoreCase("Apple iPhone 13 (128GB) - Blue")) {
                product.click();
                break;
            }
        }

        // Switch to the new tab if opened
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        // Click Add to Cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();

        // Handle warranty popup if it appears
        try {
            WebElement noThanksBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")));
            noThanksBtn.click();
        } catch (TimeoutException e) {
            // No popup, continue
        }

        // Wait for confirmation that item was added
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attach-accessory-cart-subtotal")));

        System.out.println("Apple iPhone 13 (128GB) - Blue added to the cart!");

        driver.quit();
    }
}
