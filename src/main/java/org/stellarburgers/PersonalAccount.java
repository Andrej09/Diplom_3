package org.stellarburgers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccount {
    private WebDriver driver;

    public PersonalAccount(WebDriver driver){
        this.driver = driver;
    }


    private By logo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    private By designer = By.xpath(".//p[text() = 'Конструктор']");
    private By text = By.xpath(".//h1[text() = 'Соберите бургер']");
    private By exit = By.xpath(".//button[text() = 'Выход']");
    private By enter = By.xpath(".//h2[text() = 'Вход']");
    private By element = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");

    public PersonalAccount clickExitButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(exit));
        driver.findElement(exit).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(enter));
        return this;
    }

    public PersonalAccount clickLogoButton(){
        driver.findElement(logo).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(text));
        return this;
    }
    public PersonalAccount waitingElement(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }
    public PersonalAccount clickDesignerButton(){
        driver.findElement(designer).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(text));
        return this;
    }
}

