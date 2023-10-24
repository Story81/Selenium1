package org.example.project.steps;

import io.qameta.allure.Step;
import org.example.project.pages.MainPage;


public class
MainPageSteps {
    @Step ("Выбираем расходы")
    public FillFieldBTripSteps filterByAssignment() {
        MainPage mainPage = new MainPage();
        mainPage.costsClick();
        mainPage.assignmentClick();
        return new FillFieldBTripSteps();
    }
}
