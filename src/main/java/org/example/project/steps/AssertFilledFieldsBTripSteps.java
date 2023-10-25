package org.example.project.steps;

import io.qameta.allure.Step;
import org.example.project.BasePage;
import org.example.project.pages.AssertFilledFieldsBTripPage;

public class AssertFilledFieldsBTripSteps extends BasePage {
    AssertFilledFieldsBTripPage assertFilledFieldsBTripPage = new AssertFilledFieldsBTripPage();

    @Step("Проверка заполненных полей формы создания командировки")
    public AssertFilledFieldsBTripSteps assertFieldsBTrip() {
        assertFilledFieldsBTripPage.assertFilledField();
        return new AssertFilledFieldsBTripSteps();
    }

    @Step("Нажатие кнопки 'Сохранить и закрыть'")
    public AssertFilledFieldsBTripSteps saveAndClose() {
        assertFilledFieldsBTripPage.saveAndClose();
        return new AssertFilledFieldsBTripSteps();
    }

    @Step("Проверка отображения сообщения: 'Список командируемых сотрудников не может быть пустым'")
    public void assertFinalMassage() {
        assertFilledFieldsBTripPage.assertMessage();
    }
}
