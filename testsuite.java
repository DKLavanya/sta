package testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class testsuite {
    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void testOpenSpotify() {
        driver.get("https://open.spotify.com");
    }

    public void testClickLogin() {
        driver.findElement(By.linkText("Log in")).click();
    }

    public void testSearchButton() {
        driver.findElement(By.linkText("Search")).click();
    }

    public void testBrowseLink() {
        driver.findElement(By.linkText("Browse")).click(); // if available
    }

    public void tearDown() {
        driver.quit();
    }

    // ✅ Add this main method
    public static void main(String[] args) {
        testsuite ts = new testsuite();
        ts.setup();
        ts.testOpenSpotify();
        ts.testClickLogin();
        ts.testSearchButton();
        ts.testBrowseLink();
        ts.tearDown();
    }
}
