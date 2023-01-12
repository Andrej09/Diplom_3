import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.*;

public class EnterTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginUsingLoginAccountButtonHomePage() {
        var user = new UserGenerator().random();
        LoginStellarBurgers client = new LoginStellarBurgers(driver);
        RegistrationStellarBurgers registration = new RegistrationStellarBurgers(driver);
        HomePageStellarBurgers homepage = new HomePageStellarBurgers(driver);
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
    public void loginPersonalAccountButton() {
        var user = new UserGenerator().random();
        LoginStellarBurgers client = new LoginStellarBurgers(driver);
        RegistrationStellarBurgers registration = new RegistrationStellarBurgers(driver);
        HomePageStellarBurgers homepage = new HomePageStellarBurgers(driver);
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
    public void loginButtonRegistrationForm() {
        var user = new UserGenerator().random();
        LoginStellarBurgers client = new LoginStellarBurgers(driver);
        RegistrationStellarBurgers registration = new RegistrationStellarBurgers(driver);
        HomePageStellarBurgers homepage = new HomePageStellarBurgers(driver);
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
    public void loginButtonPasswordRecoveryForm() {
        var user = new UserGenerator().random();
        PasswordRecoveryStellarBurgers recover = new PasswordRecoveryStellarBurgers(driver);
        LoginStellarBurgers client = new LoginStellarBurgers(driver);
        RegistrationStellarBurgers registration = new RegistrationStellarBurgers(driver);
        HomePageStellarBurgers homepage = new HomePageStellarBurgers(driver);
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
