package ru.ibs.tests;

import org.example.project.steps.LoginSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.tests.extension.DriverExtension;

import java.util.Properties;

import static org.example.project.properties.TestProperties.getInstance;

@ExtendWith(DriverExtension.class)
public class SecondTest {
    private final Properties properties = getInstance().getProperties();
    private final LoginSteps loginSteps = new LoginSteps();


    @Test
    public void test() {

        loginSteps
                .login(properties.getProperty("LOGIN"),
                        properties.getProperty("PASSWORD"))
                .filterByAssignment()
                .filledField
                        (properties.getProperty("inputArrivalCity"),
                                properties.getProperty("inputDepartureCity"),
                                properties.getProperty("departureDate"),
                                properties.getProperty("returnDate"))
                .assertFieldsBTrip();
    }
}
