import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.*;

public class PersonalAccountTest {

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
    @DisplayName("Checking the click-through to the \"Personal Account\"")
    public void transferPersonalAccount() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        HomePage main = new HomePage(driver);
        PersonalAccount personal = new PersonalAccount(driver);
        Registration registration = new Registration(driver);
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.waitingElement();
        personal.clickExitButton();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }


    @Test
    @DisplayName("Checking the transition to the \"Constructor\" by clicking on the Stellar Burgers logo")
    public void switchingFromPersonalAccountLogo() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        HomePage main = new HomePage(driver);
        PersonalAccount personal = new PersonalAccount(driver);
        Registration registration = new Registration(driver);
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.clickLogoButton();
        main.clickPersonalAccountButton();
        personal.clickExitButton();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }

    @Test
    @DisplayName("Check the transition by clicking on the \"Constructor\" in the constructor")
    public void switchingFromPersonalAccountDesigner() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        HomePage main = new HomePage(driver);
        PersonalAccount personal = new PersonalAccount(driver);
        Registration registration = new Registration(driver);
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.clickDesignerButton();
        main.clickPersonalAccountButton();
        personal.clickExitButton();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }

    @Test
    @DisplayName("Checking the exit by clicking the \"Exit\" button in your personal account")
    public void logoutAccount() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        HomePage main = new HomePage(driver);
        PersonalAccount personal = new PersonalAccount(driver);
        Registration registration = new Registration(driver);
        registration
                .open()
                .register(user);
        client.Login(user);
        main.clickPersonalAccountButton();
        personal.clickExitButton();
        String accessToken = client.Login(user).extract().path("accessToken");
        client.delete(accessToken);
    }

}
