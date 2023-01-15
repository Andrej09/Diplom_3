import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.sitepages.HomePage;
import org.stellarburgers.sitepages.Login;
import org.stellarburgers.sitepages.PersonalAccount;
import org.stellarburgers.sitepages.Registration;
import org.stellarburgers.user.User;
import org.stellarburgers.user.UserGenerator;

public class PersonalAccountTest {

    private WebDriver driver;
    private User user;
    private Login client;
    private Registration registration;
    private HomePage main;
    private String accessToken;
    private PersonalAccount personal;

    @Before
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "src/properties/chromedriver.exe");
        driver = new ChromeDriver();
        user = new UserGenerator().random();
        client = new Login(driver);
        registration = new Registration(driver);
        main = new HomePage(driver);
        personal = new PersonalAccount(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        if (accessToken != null) {
            client.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Checking the click-through to the \"Personal Account\"")
    public void transferPersonalAccount() {
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.waitingElement();
        personal.clickExitButton();
        accessToken = client.Login(user).extract().path("accessToken");
    }


    @Test
    @DisplayName("Checking the transition to the \"Constructor\" by clicking on the Stellar Burgers logo")
    public void switchingFromPersonalAccountLogo() {
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.clickLogoButton();
        main.clickPersonalAccountButton();
        personal.clickExitButton();
        accessToken = client.Login(user).extract().path("accessToken");
    }

    @Test
    @DisplayName("Check the transition by clicking on the \"Constructor\" in the constructor")
    public void switchingFromPersonalAccountDesigner() {
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.clickDesignerButton();
        main.clickPersonalAccountButton();
        personal.clickExitButton();
        accessToken = client.Login(user).extract().path("accessToken");
    }

    @Test
    @DisplayName("Checking the exit by clicking the \"Exit\" button in your personal account")
    public void logoutAccount() {
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.clickExitButton();
        accessToken = client.Login(user).extract().path("accessToken");
    }

}
