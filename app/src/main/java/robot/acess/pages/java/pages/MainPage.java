package robot.acess.pages.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final String MAIN_PAGE_URL = "https://www.riotgames.com/en";
    @FindBy(xpath = "//div[@class='_16YqTG4Iq4iNJMhvvUCe3k riotbar-summoner-name']")
    private WebElement myAccountText;
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(MAIN_PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public boolean hasMyAccountText() {
        return myAccountText.getText().contains("My Account");
    }
}
