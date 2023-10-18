package org.example.project;

import org.example.project.properties.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

import static java.lang.System.setProperty;

public class DriverManager {

    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        driver = new ChromeDriver();

        setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
        driver.get(properties.getProperty("HOSTNAME"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
