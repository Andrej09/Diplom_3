package org.stellarburgers.sitepages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By loginAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private By fillingsButton = By.xpath(".//div/span[text() = 'Начинки']");
    private By saucesButton = By.xpath(".//div/span[text() = 'Соусы']");
    private By rollsButton = By.xpath(".//div/span[text() = 'Булки']");
    private By fillings = By.xpath(".//a/p[text() = 'Мясо бессмертных моллюсков Protostomia']");
    private By sauces = By.xpath(".//a/p[text() = 'Соус Spicy-X']");
    private By rolls = By.xpath(".//a/p[text() = 'Флюоресцентная булка R2-D3']");

    public HomePage open(){
        driver.get(url);
        return this;
    }

    public HomePage clickFillingsButton(){
        driver.findElement(fillingsButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(fillings));
        return this;
    }

    public HomePage clickSaucesButton(){
        driver.findElement(saucesButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(sauces));
        return this;
    }

    public HomePage clickRollsButton(){
        driver.findElement(rollsButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rolls));
        return this;
    }

    public HomePage clickPersonalAccountButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        driver.findElement(personalAccountButton).click();
        return this;
    }


    public HomePage clickLoginAccountButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginAccountButton));
        driver.findElement(loginAccountButton).click();
        return this;
    }



}
