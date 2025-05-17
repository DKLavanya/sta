package scriptinjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class scriptinjava {
    public static void main(String[] args) {
        // Set path to your local chromedriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");

        // Create ChromeDriver instance (local browser)
        WebDriver driver = new ChromeDriver();

        // Open Google homepage
        driver.get("https://www.google.com");

        // Print page title
        System.out.println("Page title is: " + driver.getTitle());

        // Close browser
        driver.quit();
    }
}
