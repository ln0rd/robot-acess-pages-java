package robot.acess.pages.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final String LOGIN_PAGE_URL = "https://auth.riotgames.com/login#client_id=prod-xsso-riotgames&code_challenge=dA04P2vcaFyBubOZvIePiJtykmxrA561fsAWjSQVpKk&code_challenge_method=S256&redirect_uri=https%3A%2F%2Fxsso.riotgames.com%2Fredirect&response_type=code&scope=openid%20account%20email&state=5a0e0bce93246ca1bc0a85ea48";

    @FindBy(xpath = "//h5[@class='heading text__web-h5 grid-panel-web__title']")
    private WebElement pageTitle;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@title='Sign In']")
    private WebElement singInButton;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(LOGIN_PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void fillUsernameInput(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void fillPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public boolean isPageOpen() {
        return pageTitle.getText().contains("Sign In");
    }

    public void clickInSingIn() {
        singInButton.click();
    }

}
