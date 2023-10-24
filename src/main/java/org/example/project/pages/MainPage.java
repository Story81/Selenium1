package org.example.project.pages;

import io.qameta.allure.Step;
import org.example.project.BasePage;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BasePage {
    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[text()='Расходы']")
    private WebElement costsBtn;
    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[text()='Расходы']//ancestor::li//ul[@class = 'dropdown-menu menu_level_1']")
    private WebElement dropDownList;
    @FindBy(xpath = "//span[text()='Командировки']")
    private WebElement assignmentBtn;
    @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder']/a[text()='Создать командировку']")
    private WebElement createBusinessTripBtn;
    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement headerCreateBusinessTrip;

//    @Step(value = "Клик на кнопку Расходы")                          // Шаг 3. В выплывающем окне раздела Расходы нажать на Командировки
    public void costsClick() {
        costsBtn.click();
    }
//    @Step(value = "Нажать на \"Создать командировку\"")
    public void assignmentClick() {
        wait.until(visibilityOf(dropDownList));
        assignmentBtn.click();
        loading();
        createBusinessTripBtn.click();                                 //Шаг 4. Нажать на "Создать командировку"
        loading();
        wait.until(visibilityOf(headerCreateBusinessTrip));            // Шаг 5. Проверить наличие на странице заголовка "Создать командировку"
    }
}
