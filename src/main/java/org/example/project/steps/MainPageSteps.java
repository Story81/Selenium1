package org.example.project.steps;

import io.qameta.allure.Step;
import org.example.project.pages.MainPage;

public class
MainPageSteps {
    final MainPage mainPage = new MainPage();

    @Step("Нажать на кнопку 'Расходы'")
    public MainPageSteps costsBtnClick() {
        mainPage.costsClick();
        return new MainPageSteps();
    }

    @Step("В выплывающем окне раздела 'Расходы' нажать на 'Командировки'")
    public MainPageSteps btnAssignment() {
        mainPage.assignmentBtnClick();
        return new MainPageSteps();
    }

    @Step("Нажать на 'Создать командировку'")
    public FillFieldBTripSteps filterByAssignment() {
        mainPage.assignmentCreate();
        return new FillFieldBTripSteps();
    }
}
