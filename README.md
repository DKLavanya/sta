Steps to Set Up and Run Java Selenium Project in Eclipse

1. Download Eclipse IDE from:
https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2025-03/R/eclipse-inst-jre-win64.exe

2. Download Selenium JAR files from:
https://www.selenium.dev/downloads/
(Stable version: 4.32.0, May 02, 2025)

3. Complete Eclipse installation and setup.

4. Create a new Java project in Eclipse:

Go to File → New → Java Project

Enter project name (e.g., automation)

Click Finish

5. Delete the module-info.java file:

Expand the src folder

Right-click module-info.java → Delete

6. Create a new package:

Right-click on src → New → Package

Enter package name (e.g., webaut)

Click Finish

7. Create a new Java class:

Right-click the package (e.g., webaut) → New → Class

Enter class name (e.g., webautomation)

Select public static void main(String[] args) option

Click Finish

8. Extract the downloaded Selenium JAR files.

Add Selenium JAR files to your project build path:

Right-click on the Java project → Properties

Go to Java Build Path → Libraries tab

Select Classpath → Click Add External JARs

Browse and select all the extracted Selenium JAR files → Click Open

Click Apply and Close

9. Verify that the Selenium JAR files appear under the project as Referenced Libraries in Package Explorer.

10. Your workspace is now ready to write and run Selenium automation code.




**Selenium + testng**

Procedure to Integrate Selenium with TestNG
Set up your Java project
Create a new Java project in your IDE (like Eclipse or IntelliJ).

Add Selenium and TestNG libraries

Using Maven: Add these dependencies in your pom.xml:

<dependencies>
    <!-- Selenium Java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.9.1</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.7.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

Java code for selenum + testng:

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


**Integrate testng with maven:**

1. Create a Maven Project in Eclipse
File → New → Maven Project

Choose a simple archetype like maven-archetype-quickstart

Click Next and finish the wizard

2. Add TestNG dependency to pom.xml
Open pom.xml and add inside <dependencies>:

<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.7.0</version>
    <scope>test</scope>
</dependency>
Save the file, Maven will download TestNG automatically.

3. Create a TestNG test class
Right-click src/test/java → New → Class

Name it SimpleTest(package,class)

Add this code:

package SimpleTest;

import org.testng.annotations.Test;

public class SimpleTest {
    @Test
    public void testMethod() {
        System.out.println("TestNG test running with Maven in Eclipse!");
    }
}
4. Run TestNG test
Right-click on SimpleTest.java → Run As → TestNG Test

If you don’t see TestNG Test, do this:

Right-click project → Build Path → Configure Build Path → Add Library → TestNG → Finish

Then try running again.
