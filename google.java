package googleaut;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class google{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(
            new ChromeOptions().addArguments("--disable-infobars", "--start-maximized")
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open Google
        driver.get("https://www.google.com");

        // Accept cookies if prompted (some regions)
        try {
            WebElement accept = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Accept all']")));
            accept.click();
        } catch (Exception ignored) {}

        // Search "iPhone 13"
        wait.until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys("iPhone 13", Keys.ENTER);

        // Click the first result
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h3")));
        firstResult.click();

        System.out.println("✅ Clicked first Google search result!");
        driver.quit();
    }
}
