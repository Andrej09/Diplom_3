package org.stellarburgers.sitepages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private By fillingsSection = By.xpath(".//h2[text() = 'Начинки']");
    private By saucesSection = By.xpath(".//h2[text() = 'Соусы']");
    private By rollsSection = By.xpath(".//h2[text() = 'Булки']");
    private By selectedSection = By.className("tab_tab_type_current__2BEPc");


    public HomePage open(){
        driver.get(url);
        return this;
    }

    public HomePage clickFillingsButton(){
        driver.findElement(fillingsButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsSection));
        return this;
    }

    public HomePage clickSaucesButton(){
        driver.findElement(saucesButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesSection));
        return this;
    }

    public HomePage clickRollsButton(){
        driver.findElement(rollsButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(rollsSection));
        return this;
    }

    public HomePage checkActiveSection( String section) {
        driver.findElement(selectedSection).getText().equals(section);
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
