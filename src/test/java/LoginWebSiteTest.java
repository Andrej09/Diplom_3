import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.*;

public class LoginWebSiteTest {

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
    @DisplayName("Checking the login using the \"Log in to account\" button on the main page")
    public void loginUsingLoginAccountButtonHomePage() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        Registration registration = new Registration(driver);
        HomePage homepage = new HomePage(driver);
        registration
                .open()
                .register(user);
        homepage
                .open()
                .clickLoginAccountButton();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }

    @Test
    @DisplayName("Checking the login via the \"Personal Account\" button")
    public void loginPersonalAccountButton() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        Registration registration = new Registration(driver);
        HomePage homepage = new HomePage(driver);
        registration
                .open()
                .register(user);
        homepage
                .open()
                .clickPersonalAccountButton();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }

    @Test
    @DisplayName("Checking the login via the button in the registration form")
    public void loginButtonRegistrationForm() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        Registration registration = new Registration(driver);
        HomePage homepage = new HomePage(driver);
        registration
                .open()
                .register(user);
        homepage
                .open()
                .clickPersonalAccountButton();
        client.clickRegistrationButton();
        registration.clickButtonEnter();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }

    @Test
    @DisplayName("Checking the login via the button in the password recovery form")
    public void loginButtonPasswordRecoveryForm() {
        var user = new UserGenerator().random();
        PasswordRecovery recover = new PasswordRecovery(driver);
        Login client = new Login(driver);
        Registration registration = new Registration(driver);
        HomePage homepage = new HomePage(driver);
        registration
                .open()
                .register(user);
        homepage
                .open()
                .clickPersonalAccountButton();
        client.clickRecoverPasswordButton();
        recover.clickLogin();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }

}
