package org.example.project.steps;

import io.qameta.allure.Step;
import org.example.project.BasePage;
import org.example.project.pages.AssertFilledFieldsBTripPage;

public class AssertFilledFieldsBTripSteps extends BasePage {
    AssertFilledFieldsBTripPage assertFilledFieldsBTripPage = new AssertFilledFieldsBTripPage();

    @Step
    public void assertFieldsBTrip() {
        assertFilledFieldsBTripPage.assertFilledField();
        assertFilledFieldsBTripPage.saveAndClose();
        assertFilledFieldsBTripPage.assertMessage();
    }
}
