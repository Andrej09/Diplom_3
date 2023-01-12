package org.stellarburgers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecovery {

    private WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    public PasswordRecovery(WebDriver driver){
        this.driver = driver;
    }

    private By emailField = By.xpath(".//input[@type = 'text' and @name = 'name']");
    private By buttonRecover = By.xpath(".//button[text() = 'Восстановить']");
    private By buttonEnter = By.xpath(".//a[text() = 'Войти']");

    public PasswordRecovery open(){
        driver.get(url);
        return this;
    }

    public PasswordRecovery setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public PasswordRecovery clickRecoverButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonRecover));
        driver.findElement(buttonRecover).click();
        return this;
    }

    public PasswordRecovery clickLogin(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonEnter));
        driver.findElement(buttonEnter).click();
        return this;
    }


}
