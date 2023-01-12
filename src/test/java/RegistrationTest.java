import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.Login;
import org.stellarburgers.Registration;
import org.stellarburgers.UserGenerator;

public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Test
    @DisplayName("Verification of successful registration")
    public void userRegistration() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        Registration registration = new Registration(driver);
        registration
                .open()
                .register(user);
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }


    @Test
    @DisplayName("Checking the minimum number of characters in the password — six characters")
    public void errorEnteringIncorrectPassword() {
        var user = new UserGenerator().random();
        Registration registration = new Registration(driver);
        user.setPassword("12345");
        registration
                      .open()
                      .register(user)
                      .waitInvalidPassword();
    }
}
