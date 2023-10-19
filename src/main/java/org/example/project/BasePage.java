package org.example.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.example.project.DriverManager.getWebDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {
    protected static WebDriver driver = getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
    @FindBy(xpath = "//div[@class='loader-mask shown']")
    private WebElement loadingIcon;

    public BasePage() {
        initElements(driver, this);
    }

    public void loading() {
        wait.until(ExpectedConditions.invisibilityOf(loadingIcon));
    }
}
