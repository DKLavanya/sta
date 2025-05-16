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

