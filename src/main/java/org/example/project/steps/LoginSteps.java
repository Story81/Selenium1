package org.example.project.steps;

import org.example.project.pages.LoginPage;

public class LoginSteps {
    public MainPageSteps login(String login, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterLoginAndPassword(login, password);
        loginPage.submitClick();
        return new MainPageSteps();
    }
}
