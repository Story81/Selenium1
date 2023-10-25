package org.example.project.steps;

import io.qameta.allure.Step;
import org.example.project.pages.FillFieldsOfBTripPage;

public class FillFieldBTripSteps {
    final FillFieldsOfBTripPage fillFieldsOfBTripPage = new FillFieldsOfBTripPage();

    @Step("Заполняем поле 'Подразделение' значением 'Отдел внутренней разработки'")
    public FillFieldBTripSteps filledFieldDivision() {
        fillFieldsOfBTripPage.filledFieldBTripDivision();
        return new FillFieldBTripSteps();
    }

    @Step("Выбираем из списка принимающую организацию")
    public FillFieldBTripSteps filledFieldCompany() {
        fillFieldsOfBTripPage.filledFieldBTripCompany();
        return new FillFieldBTripSteps();
    }

    @Step("Заполняем поля командировки: города выбытия и прибытия, даты выезда и возвращения")
    public AssertFilledFieldsBTripSteps filledField(String inputArrivalCity, String inputDepartureCity, String departureDate, String returnDate) {

        fillFieldsOfBTripPage.filledFieldBTrip(inputArrivalCity, inputDepartureCity, departureDate, returnDate);
        return new AssertFilledFieldsBTripSteps();
    }
}
