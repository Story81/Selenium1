package ru.ibs.tests;


//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//import static org.junit.jupiter.api.AssertTrue.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FirstProject {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(2));


    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.get("http://training.appline.ru/user/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {

// Шаг 1. Авторизация

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("Taraskina Valeriya");
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

// Шаг 2. Проверить наличие на странице заголовка Панель быстрого запуска
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));

// Шаг 3. В выплывающем окне раздела Расходы нажать на Командировки
        WebElement costsList = driver.findElement(By.xpath(
                "//ul[contains(@class,'main-menu')]/li/a/span[text()='Расходы']"));
        costsList.click();
        wait.until(ExpectedConditions.visibilityOf(costsList.findElement(By.xpath(
                "./ancestor::li//ul[@class = 'dropdown-menu menu_level_1']"))));
        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        loading();

 //Шаг 4. Нажать на "Создать командировку"
        driver.findElement(By.xpath(
                "//div[@class='pull-left btn-group icons-holder']/a[text()='Создать командировку']")).click();
        loading();

// Шаг 5. Проверить наличие на странице заголовка "Создать командировку"
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='user-name']"))));

 /**Шаг 6. На странице создания командировки заполнить или выбрать поля:
         * — Подразделение - выбрать Отдел внутренней разработки
         * — Принимающая организация - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
         * — В задачах поставить чекбокс на "Заказ билетов"
         * — Указать города выбытия и прибытия
         * — Указать даты выезда и возвращения
         *
         */
        WebElement division = driver.findElement(By.xpath("//option[@value='7']"));
        division.click();
        WebElement checkBox = driver.findElement(By.xpath("//input[@value='1']"));
        checkBox.click();

        WebElement listOfCompanies = driver.findElement(By.xpath("//a[@id='company-selector-show']"));
        listOfCompanies.click();
        WebElement fieldCompany = driver.findElement(By.xpath("//a[@class='select2-choice select2-default']"));
        fieldCompany.click();
        WebElement nameCompany = driver.findElement(By.xpath("//div[contains(text(),'Хром')]"));
        nameCompany.click();

        WebElement departureCity = driver.findElement(By.xpath("//input[@name='crm_business_trip[departureCity]']"));
        departureCity.clear();
        departureCity.sendKeys("Россия, Омск");
        WebElement arrivalCity = driver.findElement(By.xpath("//input[@name='crm_business_trip[arrivalCity]']"));
        arrivalCity.sendKeys("Россия, Мурманск");


        WebElement dateField = driver.findElement(By.xpath(
                "//input[contains(@id, 'date_selector_crm_business_trip_departureDatePlan')]"));
        dateField.sendKeys("10.11.2023");
        WebElement returnDateField = driver.findElement(By.xpath(
                "//input[contains(@id, 'date_selector_crm_business_trip_returnDatePlan')]"));
        returnDateField.sendKeys("10.12.2023");
        returnDateField.sendKeys(Keys.ESCAPE);


//Шаг  7. Проверить, что все поля заполнены правильно
        assertTrue(Boolean.parseBoolean(checkBox.getAttribute("checked")),"Чекбокс не включен");
        assertTrue(division.getText().contains("Отдел внутренней разработки"),"Выбрано неверное подразделение");
        assertEquals("Россия, Омск", departureCity.getAttribute("value"),"Город выбытия указан не верно");
        assertEquals( "Россия, Мурманск", arrivalCity.getAttribute("value"),"Город прибытия указан не верно");
        assertEquals("(Хром) Призрачная Организация Охотников", fieldCompany.getText(),"Организация указана не верно");
        assertEquals("10.11.2023", dateField.getAttribute("value"),"Город выбытия указан не верно");
        assertEquals("10.12.2023", returnDateField.getAttribute("value"),"Город прибытия указан не верно");

// Шаг 8. Нажать "Сохранить и закрыть"
        WebElement saveAndClose = driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]"));
        saveAndClose.click();
        loading();

// Шаг 9. Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
//      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='validation-failed']"))));
        WebElement validationMessage = driver.findElement(By.xpath("//span[@class='validation-failed']"));
        assertEquals(
                "Список командируемых сотрудников не может быть пустым", validationMessage.getText(),"Сообщение о пустом списке сотрудников отсутствует");
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public void loading() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.xpath("//div[@class='loader-mask shown']"))));
    }
}
