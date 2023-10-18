package org.example.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.*;
import static org.example.project.DriverManager.*;
import static org.openqa.selenium.support.PageFactory.*;

public class BasePage {
    @FindBy(xpath = "//div[@class='loader-mask shown']")
    private WebElement loadingIcon;
    protected static WebDriver driver = getWebDriver();

    protected WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));

    public BasePage() {
        initElements(driver, this);
    }

    public void loading() {
        wait.until(ExpectedConditions.invisibilityOf(loadingIcon));
    }
}
