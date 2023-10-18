package ru.ibs.tests;


import extension.DriverExtension;
import org.example.project.DriverManager;
import org.example.project.pages.MainPage;
import org.example.project.steps.LoginSteps;
import org.example.project.steps.MainPageSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

import static java.time.Duration.ofSeconds;
import static org.example.project.properties.TestProperties.getInstance;

@ExtendWith(DriverExtension.class)
public class SecondTest {
//    private final WebDriver driver = DriverManager.getWebDriver();
//    private final WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20), ofSeconds(2));
    private final Properties properties = getInstance().getProperties();
    private final LoginSteps loginSteps = new LoginSteps();
    private final MainPageSteps mainPageSteps = new MainPageSteps();



//    @BeforeEach
//    public void before() {
//        System.setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
//        driver.get(properties.getProperty("HOSTNAME"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }

    @Test
    public void test() {

// Шаг 1. Авторизация
        loginSteps
                .login( properties.getProperty("LOGIN"),
                        properties.getProperty("PASSWORD"))
                .filterByAssignment();


// Шаг 2. Проверить наличие на странице заголовка Панель быстрого запуска
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));

// Шаг 3. В выплывающем окне раздела Расходы нажать на Командировки
//        WebElement costsList = driver.findElement(By.xpath(
//                "//ul[contains(@class,'main-menu')]/li/a/span[text()='Расходы']"));
//        costsList.click();
//        wait.until(ExpectedConditions.visibilityOf(costsList.findElement(By.xpath(
//                "./ancestor::li//ul[@class = 'dropdown-menu menu_level_1']"))));
//        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
//        loading();

    }

//    @AfterEach
//    public void after() {
//        driver.quit();
//    }


}
