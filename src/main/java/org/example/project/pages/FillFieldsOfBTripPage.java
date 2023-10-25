package org.example.project.pages;

import org.example.project.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FillFieldsOfBTripPage extends BasePage {

    @FindBy(xpath = "//option[@value='7']")                //поле подразделение
    private WebElement divisionField;

    @FindBy(xpath = "//a[@id='company-selector-show']")    //кнопка Открыть список
    private WebElement listOfCompanies;

    @FindBy(xpath = "//span[@class='select2-chosen']")      //список
    private WebElement fieldCompany;

    @FindBy(xpath = "//div[text()='(Хром) Призрачная Организация Охотников']")
    private WebElement nameCompany;

    @FindBy(xpath = "//input[@data-name='field__1']")        //чекбокс "Заказ билетов"
    private WebElement checkBoxTickets;

    @FindBy(xpath = "//input[@name='crm_business_trip[departureCity]']")
    private WebElement departureCity;
    @FindBy(xpath = "//input[@name='crm_business_trip[arrivalCity]']")
    private WebElement arrivalCity;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_business_trip_departureDatePlan')]")
    private WebElement dateField;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_business_trip_returnDatePlan')]")
    private WebElement returnDateField;

    public void filledFieldBTripDivision() {
        divisionField.click();                         //Поле Подразделение
    }

    public void filledFieldBTripCompany() {
        listOfCompanies.click();                       //кнопка Выбрать организацию из списка
        fieldCompany.click();
        nameCompany.click();
        checkBoxTickets.click();                       //Проставление чек-бокса "Заказ билетов"
    }

    public void filledFieldBTrip(String inputArrivalCity, String inputDepartureCity, String departureDate, String returnDate) {
        arrivalCity.sendKeys(inputArrivalCity);        // Заполнение поля "Город прибытия"
        departureCity.clear();
        departureCity.sendKeys(inputDepartureCity);     // Заполнение поля "Город прибытия"
        dateField.sendKeys(departureDate);              // Заполнение поля "Планируемая дата выезда*"
        returnDateField.sendKeys(returnDate);           //Заполнение поля "Планируемая дата возвращения
        returnDateField.sendKeys(Keys.ESCAPE);          // закрытие календаря
    }
}
