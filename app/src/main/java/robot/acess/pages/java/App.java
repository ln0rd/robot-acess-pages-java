/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package robot.acess.pages.java;

// reference
// https://www.lambdatest.com/blog/complete-guide-for-using-xpath-in-selenium-with-examples/
// https://medium.com/swlh/simple-selenium-test-automation-project-in-java-with-page-object-model-a18d5f5dd35
// https://bonigarcia.dev/webdrivermanager/
// https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import robot.acess.pages.java.exceptions.IsNotRightPageException;
import robot.acess.pages.java.pages.LoginPage;
import robot.acess.pages.java.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class App {
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;
    private final String fakeUsername = "seleniumTheBot";
    private final String fakePassword = "WmFCZDh7wnq9wp7Y5U3zPrYUkjCkY";

    public App() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        new App().executeBot();
    }

    public void executeBot() throws Exception {

        this.loginPage = new LoginPage(driver);
        log("Starting Process");
        delayInSec(5);
        boolean pageOpen = loginPage.isPageOpen();
        delayInSec(2);

        if (!pageOpen) {
            log("It doesn't in login page");
            throw new IsNotRightPageException();
        } else if (pageOpen) {
            log("We are in logging page");
        }

        log("Filling username");
        loginPage.fillUsernameInput(fakeUsername);
        delayInSec(2);
        log("Filling password");
        loginPage.fillPasswordInput(fakePassword);
        delayInSec(2);
        log("clicking in sing in");
        loginPage.clickInSingIn();

        delayInSec(3);
        this.mainPage = new MainPage(driver);
        boolean hasMyAccountText = mainPage.hasMyAccountText();

        if (hasMyAccountText) {
            log("Autenticado com sucesso");
        }

        delayInSec(1);
    }

    public void delayInSec(long seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public void log (String message) {
        System.out.println(message);
    }
}
