package tesst;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest{

    @Test(description = ("Test Logout"))
    public void testLogout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.login("Admin","admin123");

        DashboardPage dashboardPage = new DashboardPage(driver,wait);
        dashboardPage.Logout();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("auth/login"));
    }
}
