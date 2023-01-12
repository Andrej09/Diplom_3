package org.stellarburgers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationStellarBurgers {

    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/register";

    public RegistrationStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    private By nameField = By.xpath(".//fieldset/div/div/input[@type = 'text' and @name = 'name']");
    private By emailField = By.xpath(".//fieldset/div/div/label[text() = 'Email']//following-sibling::input");
    private By passwordField = By.xpath(".//input[@type = 'password' and @name = 'Пароль']");
    private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private By InvalidPassword = By.xpath(".//div/p[text() = 'Некорректный пароль']");
    private By buttonEnter = By.xpath(".//p/a[text() = 'Войти']");


    public RegistrationStellarBurgers open(){
        driver.get(url);
        return this;
    }

    public RegistrationStellarBurgers setUsername(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public RegistrationStellarBurgers setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegistrationStellarBurgers setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public RegistrationStellarBurgers clickRegister(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        driver.findElement(registerButton).click();
        return this;
    }

    public RegistrationStellarBurgers register(User user){
        setUsername(user.getFirstName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickRegister();
        return this;
    }

    public RegistrationStellarBurgers waitInvalidPassword(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(InvalidPassword));
        return this;
    }

    public RegistrationStellarBurgers clickButtonEnter(){
        driver.findElement(buttonEnter).click();
        return this;
    }

}
