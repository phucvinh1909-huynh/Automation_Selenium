package tesst;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test(description = "Test Login Suceess")
    public void testLoginSuccess() throws Exception{
        LoginPage loginPage = new LoginPage(driver,wait);

        loginPage.login("Admin","admin123");

       String currentUrl = driver.getCurrentUrl();

       Assert.assertTrue(currentUrl.contains("dashboard"));
    }

    @Test(description = "Test login fail")
    public void testLoginFail() throws Exception{
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.login("Admin","admin1234");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
        Assert.assertFalse(currentUrl.contains("dashboard"));
    }
}
