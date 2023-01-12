package org.stellarburgers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoveryStellarBurgers {

    private WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    public PasswordRecoveryStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    private By emailField = By.xpath(".//input[@type = 'text' and @name = 'name']");
    private By buttonRecover = By.xpath(".//button[text() = 'Восстановить']");
    private By buttonEnter = By.xpath(".//a[text() = 'Войти']");

    public PasswordRecoveryStellarBurgers open(){
        driver.get(url);
        return this;
    }

    public PasswordRecoveryStellarBurgers setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public PasswordRecoveryStellarBurgers clickRecoverButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonRecover));
        driver.findElement(buttonRecover).click();
        return this;
    }

    public PasswordRecoveryStellarBurgers clickLogin(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonEnter));
        driver.findElement(buttonEnter).click();
        return this;
    }


}
