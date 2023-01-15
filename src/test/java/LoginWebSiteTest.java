import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.sitepages.HomePage;
import org.stellarburgers.sitepages.Login;
import org.stellarburgers.sitepages.PasswordRecovery;
import org.stellarburgers.sitepages.Registration;
import org.stellarburgers.user.User;
import org.stellarburgers.user.UserGenerator;

public class LoginWebSiteTest {

    private WebDriver driver;
    private User user;
    private Login client;
    private Registration registration;
    private HomePage main;
    private PasswordRecovery recover;
    private String accessToken;

    @Before
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "src/properties/chromedriver.exe");
        driver = new ChromeDriver();
        user = new UserGenerator().random();
        client = new Login(driver);
        registration = new Registration(driver);
        main = new HomePage(driver);
        recover = new PasswordRecovery(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        if (accessToken != null) {
            client.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Checking the login using the \"Log in to account\" button on the main page")
    public void loginUsingLoginAccountButtonHomePage() {
        registration
                .open()
                .register(user);
        main
                .open()
                .clickLoginAccountButton();
        accessToken = client.Login(user).extract().path("accessToken");
    }

    @Test
    @DisplayName("Checking the login via the \"Personal Account\" button")
    public void loginPersonalAccountButton() {
        registration
                .open()
                .register(user);
        main
                .open()
                .clickPersonalAccountButton();
         accessToken = client.Login(user).extract().path("accessToken");
    }

    @Test
    @DisplayName("Checking the login via the button in the registration form")
    public void loginButtonRegistrationForm() {
        registration
                .open()
                .register(user);
        main
                .open()
                .clickPersonalAccountButton();
        client.clickRegistrationButton();
        registration.clickButtonEnter();
        accessToken = client.Login(user).extract().path("accessToken");
    }

    @Test
    @DisplayName("Checking the login via the button in the password recovery form")
    public void loginButtonPasswordRecoveryForm() {
        registration
                .open()
                .register(user);
        main
                .open()
                .clickPersonalAccountButton();
        client.clickRecoverPasswordButton();
        recover.clickLogin();
        accessToken = client.Login(user).extract().path("accessToken");
    }

}