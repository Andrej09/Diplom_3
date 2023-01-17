import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.sitepages.Login;
import org.stellarburgers.sitepages.Registration;
import org.stellarburgers.user.User;
import org.stellarburgers.user.UserGenerator;

public class RegistrationTest {

    private WebDriver driver;
    private User user;
    private Login client;
    private Registration registration;
    private String accessToken;

    @Before
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "src/test/properties/chromedriver.exe");
        driver = new ChromeDriver();
        user = new UserGenerator().random();
        client = new Login(driver);
        registration = new Registration(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        if (accessToken != null) {
            client.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Verification of successful registration")
    public void userRegistration() {
        registration
                .open()
                .register(user);
        accessToken = client.Login(user).extract().path("accessToken");
    }


    @Test
    @DisplayName("Checking the minimum number of characters in the password — six characters")
    public void errorEnteringIncorrectPassword() {
        user.setPassword("12345");
        registration
                      .open()
                      .register(user)
                      .waitInvalidPassword();
    }
}
