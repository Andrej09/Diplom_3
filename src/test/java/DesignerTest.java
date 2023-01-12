import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.stellarburgers.HomePage;
import org.stellarburgers.Login;
import org.stellarburgers.Registration;
import org.stellarburgers.UserGenerator;

public class DesignerTest {

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
    @DisplayName("Checking transitions between sections of the constructor")
    public void designerScrollTest() {
        var user = new UserGenerator().random();
        Login client = new Login(driver);
        Registration registration = new Registration(driver);
        HomePage main = new HomePage(driver);
        registration
                .open()
                .register(user);
        String accessToken = client.Login(user).extract().path("accessToken");
        main
                .scrollFillingsButton()
                .scrollSaucesButton()
                .scrollRollsButton();
        client.delete(accessToken);
    }
}
