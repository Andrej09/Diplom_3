package org.stellarburgers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountStellarBurgers {
    private WebDriver driver;

    public PersonalAccountStellarBurgers(WebDriver driver){
        this.driver = driver;
    }


    private By logo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    private By text = By.xpath(".//h1[text() = 'Соберите бургер']");
    private By exit = By.xpath(".//button[text() = 'Выход']");
    private By enter = By.xpath(".//h2[text() = 'Вход']");
    private By element = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");

    public PersonalAccountStellarBurgers clickExitButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(exit));
        driver.findElement(exit).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(enter));
        return this;
    }

    public PersonalAccountStellarBurgers clickDesignerButton(){
        driver.findElement(logo).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(text));
        return this;
    }
    public PersonalAccountStellarBurgers waitingElement(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

}

