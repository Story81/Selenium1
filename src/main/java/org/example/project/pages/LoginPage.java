package org.example.project.pages;

import org.example.project.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

import static org.example.project.properties.TestProperties.getInstance;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginFormWindow;
    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginRow;
    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordRow;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement subtitle;

    public void enterLoginAndPassword(String login, String password ) {
        wait.until(visibilityOf(loginFormWindow));
        loginRow.sendKeys(login);
        passwordRow.sendKeys(password);
    }

    public void submitClick() {
        submitButton.click();
        wait.until(visibilityOf(subtitle));
    }
}
