package org.example.project.steps;

import org.example.project.pages.MainPage;

public class MainPageSteps {
    public FillFieldBTripSteps filterByAssignment() {
        MainPage mainPage = new MainPage();
        mainPage.costsClick();
        mainPage.assignmentClick();
        return new FillFieldBTripSteps();
    }
}
