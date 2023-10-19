package org.example.project.steps;

import org.example.project.BasePage;
import org.example.project.pages.AssertFilledFieldsBTripPage;

public class AssertFilledFieldsBTripSteps extends BasePage {
    AssertFilledFieldsBTripPage assertFilledFieldsBTripPage = new AssertFilledFieldsBTripPage();

    public void assertFieldsBTrip() {
        assertFilledFieldsBTripPage.assertFilledField();
        assertFilledFieldsBTripPage.saveAndClose();
        assertFilledFieldsBTripPage.assertMessage();
    }
}
