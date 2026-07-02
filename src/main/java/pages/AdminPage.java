package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage{
    private static final By USER_INPUT = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private static final By USER_ROLE_SELECT = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private static final By ADMIN_ROLE_OPTION = By.xpath("//div[@role='option' and text()='Admin']");
    private static final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private static final By DATA_ROLE = By.xpath("//div[@class='oxd-table-card']");

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

}
