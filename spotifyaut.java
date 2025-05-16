package spotifyaut;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class spotifyaut {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(
            new ChromeOptions().addArguments("--disable-infobars", "--start-maximized")
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String searchQuery = "Imagine Dragons";

        try {
            driver.get("https://open.spotify.com/");

            // Wait until title contains Spotify
            wait.until(ExpectedConditions.titleContains("Spotify"));
            System.out.println("Homepage loaded successfully.");

            // Click Search menu item
            WebElement searchMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/search' and contains(@class, 'link')]")));
            searchMenu.click();

            // Wait for search input and focus
            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@data-testid='search-input']")));
            searchInput.click();

            // Use JS to input the search query and trigger input event
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                "arguments[0].value = arguments[1];" +
                "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                searchInput, searchQuery);

            // Press ENTER to search
            searchInput.sendKeys(Keys.ENTER);

            // Wait for search results container
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[contains(@aria-label,'Search results')]")));

            System.out.println("Search results loaded.");

            // Check if results found
            boolean hasResults = driver.findElements(By.xpath("//div[@data-testid='tracklist-row']")).size() > 0;
            if (hasResults) {
                System.out.println("Test Passed: Search results displayed.");
            } else {
                System.out.println("Test Failed: No search results found.");
            }

        } catch (Exception e) {
            System.out.println("Test Failed with exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
