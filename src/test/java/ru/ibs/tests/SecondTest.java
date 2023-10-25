package ru.ibs.tests;

import io.qameta.allure.*;
import org.example.project.steps.LoginSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.tests.extension.AllureExtension;
import ru.ibs.tests.extension.DriverExtension;

import java.util.Properties;

import static org.example.project.properties.TestProperties.getInstance;
@DisplayName(value = "Сценарий оформления командировки")
@Owner("Сoломенникова Н.М.")
@TmsLink("Test 123")
@ExtendWith({DriverExtension.class, AllureExtension.class})
public class SecondTest {
    private final Properties properties = getInstance().getProperties();
    private final LoginSteps loginSteps = new LoginSteps();


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет,что нельзя оформить командировку при наличии обязательных незаполненных полей")
     void testCreateBisinessTrip() {

        loginSteps
                .login(properties.getProperty("LOGIN"),
                        properties.getProperty("PASSWORD"))
                .submitBtnClick()
                .costsBtnClick()
                .btnAssignment()
                .filterByAssignment()
                .filledFieldDivision()
                .filledFieldCompany()
                .filledField
                        (properties.getProperty("inputArrivalCity"),
                                properties.getProperty("inputDepartureCity"),
                                properties.getProperty("departureDate"),
                                properties.getProperty("returnDate"))
                .assertFieldsBTrip()
                .saveAndClose()
                .assertFinalMassage();
    }
}
