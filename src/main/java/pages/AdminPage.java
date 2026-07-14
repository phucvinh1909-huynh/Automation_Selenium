package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {
    private static final By USER_INPUT = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private static final By USER_ROLE_SELECT = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private static final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private static final By DATA_ROW = By.xpath("//div[@class='oxd-table-card']");
    private static final By ADMIN_ROLE_OPTION = By.xpath("//div[@role='option']//span[text()='Admin']");
    private static final By RECORD_COUNT_TEXT = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span");

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        Allure.step("Open Admin Page", () -> {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
            //wait.until(driver ->((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
            wait.until(ExpectedConditions.elementToBeClickable(USER_INPUT));
        });
    }


    public void enterUserName(String userName) throws InterruptedException {
        Allure.step("Enter user name" + userName, () -> {
            WebElement userInput = driver.findElement(USER_INPUT);
            highlight(userInput);
            userInput.sendKeys(userName);
            unhighlight(userInput);
            Thread.sleep(1000);
        });
    }

    public void selectUserRole(String role) throws InterruptedException {
        Allure.step("Select user role" + role, () -> {
            WebElement roleSelect = driver.findElement(USER_ROLE_SELECT);
            highlight(roleSelect);
            roleSelect.click();
            unhighlight(roleSelect);

            String xpath = "//div[@role='option']//span[text()='" + role + "'])";
            String xpath2 = String.format("//div[@role='option']//span[text()='%s']", role);
            WebElement adminRoleOption = driver.findElement(By.xpath(xpath2));
            highlight(adminRoleOption);
            adminRoleOption.click();
            unhighlight(adminRoleOption);
            Thread.sleep(1000);
        });
    }

    public void clickSearchButton() throws InterruptedException {
        Allure.step("Click search button", () -> {
            WebElement searchButton = driver.findElement(SEARCH_BUTTON);
            highlight(searchButton);
            searchButton.click();
            unhighlight(searchButton);
            Thread.sleep(1000);
        });
    }

    public void filterByUser(String username, String role) throws InterruptedException {
        enterUserName(username);
        selectUserRole(role);
        clickSearchButton();
    }

    public boolean checkNumberOfRecords() throws InterruptedException {
        return Allure.step("Check number of records", () -> {
            WebElement recordCountText = driver.findElement(RECORD_COUNT_TEXT);
            // WebElement recordCountText = driver.(RECORD_COUNT_TEXT);
            String text = recordCountText.getText();
            int countRecord = Integer.parseInt(text.replaceAll("\\D+", ""));
            System.out.println("Number of records: " + countRecord);

            int countDataRows = driver.findElements(DATA_ROW).size();

            return countRecord == countDataRows;
        });
    }
}
