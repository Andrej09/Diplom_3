import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.sitepages.HomePage;
import org.stellarburgers.sitepages.Login;
import org.stellarburgers.sitepages.Registration;
import org.stellarburgers.user.User;
import org.stellarburgers.user.UserGenerator;

public class DesignerTest {

    private WebDriver driver;
    private User user;
    private Login client;
    private Registration registration;
    private HomePage main;
    private String accessToken;

    @Before
    public void setUp() {
        System.setProperty("web-driver.chrome.driver", "src/test/properties/chromedriver.exe");
        driver = new ChromeDriver();
        user = new UserGenerator().random();
        client = new Login(driver);
        registration = new Registration(driver);
        main = new HomePage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        if (accessToken != null) {
            client.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Checking the transition to the bread section")
    public void CheckingTransitionBreadSection() {
        registration
                .open()
                .register(user);
        accessToken = client.Login(user).extract().path("accessToken");
        main
                .clickSaucesButton()
                .clickRollsButton()
                .checkActiveSection("Булки");
    }

    @Test
    @DisplayName("Checking the transition to the sauces section")
    public void CheckingTransitionSaucesSection() {
        registration
                .open()
                .register(user);
        accessToken = client.Login(user).extract().path("accessToken");
        main
                .clickSaucesButton()
                .checkActiveSection("Соусы");
    }

    @Test
    @DisplayName("Checking the transition to the filling section")
    public void CheckingTransitionFillingSection() {
        registration
                .open()
                .register(user);
        accessToken = client.Login(user).extract().path("accessToken");
        main
                .clickFillingsButton()
                .checkActiveSection("Начинки");
    }
}
