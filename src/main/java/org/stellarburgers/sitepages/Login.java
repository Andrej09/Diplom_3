package org.stellarburgers.sitepages;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.stellarburgers.user.User;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class Login {
    private WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    private final String url = "https://stellarburgers.nomoreparties.site/login";

    private By emailField = By.xpath(".//input[@type = 'text' and @name = 'name']");
    private By passwordField = By.xpath(".//input[@type = 'password' and @name = 'Пароль']");
    private By buttonEnter = By.xpath(".//button[text() = 'Войти']");
    private By buttonRegistration = By.xpath(".//p/a[text() = 'Зарегистрироваться']");
    private By buttonRecoverPassword = By.xpath(".//p/a[text() = 'Восстановить пароль']");

    public Login open(){
        driver.get(url);
        return this;
    }

    public Login clickRegistrationButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonRegistration));
        driver.findElement(buttonRegistration).click();
        return this;
    }

    public Login clickRecoverPasswordButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonRecoverPassword));
        driver.findElement(buttonRecoverPassword).click();
        return this;
    }

    public Login setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public Login setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public Login clickLogin(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonEnter));
        driver.findElement(buttonEnter).click();
        return this;
    }

    public ValidatableResponse Login(User user){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonEnter));
       setEmailField(user.getEmail());
       setPasswordField(user.getPassword());
       clickLogin();
       var json = new User(user.getEmail(), user.getPassword(), user.getFirstName());
       return given()
               .contentType(ContentType.JSON)
               .body(json)
               .when()
               .post("https://stellarburgers.nomoreparties.site/api/auth/login")
               .then().log().all();
    }

    public ValidatableResponse delete(String accessToken) {
        return given()
                .contentType(ContentType.JSON)
                .auth().oauth2(accessToken.replace("Bearer ", ""))
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then()
                .log().all().statusCode(202);
    }


}
