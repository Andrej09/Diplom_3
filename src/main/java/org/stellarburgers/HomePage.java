package org.stellarburgers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageStellarBurgers {
    private WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site";

    public HomePageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }
    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By loginAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private By fillingsButton = By.xpath(".//div/span[text() = 'Начинки']");
    private By saucesButton = By.xpath(".//div/span[text() = 'Соусы']");
    private By rollsButton = By.xpath(".//div/span[text() = 'Булки']");

    public HomePageStellarBurgers open(){
        driver.get(url);
        return this;
    }

    public HomePageStellarBurgers scrollFillingsButton(){
        WebElement element = driver.findElement(fillingsButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsButton));
        return this;
    }

    public HomePageStellarBurgers scrollSaucesButton(){
        WebElement element = driver.findElement(saucesButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesButton));
        return this;
    }

    public HomePageStellarBurgers scrollRollsButton(){
        WebElement element = driver.findElement(rollsButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(rollsButton));
        return this;
    }

    public HomePageStellarBurgers clickPersonalAccountButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        driver.findElement(personalAccountButton).click();
        return this;
    }


    public HomePageStellarBurgers clickLoginAccountButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginAccountButton));
        driver.findElement(loginAccountButton).click();
        return this;
    }



}
