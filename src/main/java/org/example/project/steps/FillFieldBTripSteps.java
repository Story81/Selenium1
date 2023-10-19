package org.example.project.steps;

import org.example.project.pages.FillFieldsOfBTripPage;

public class FillFieldBTripSteps {

    public AssertFilledFieldsBTripSteps filledField(String inputArrivalCity, String inputDepartureCity, String departureDate, String returnDate) {
        FillFieldsOfBTripPage fillFieldsOfBTripPage = new FillFieldsOfBTripPage();
        fillFieldsOfBTripPage.FilledFieldBTrip(inputArrivalCity, inputDepartureCity, departureDate, returnDate);
        return new AssertFilledFieldsBTripSteps();
    }
}
