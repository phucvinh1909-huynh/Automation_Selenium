package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.parser.Element;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver;
    }

    //funtion hightlight
    public void highlight(WebElement element) {
        js.executeScript("arguments[0].style.border='2px solid green';", element);
        js.executeScript("arguments[0].style.backgroundColor='brown';",element);
    }

    public void unhighlight(WebElement element) {
        try {
            js.executeScript("arguments[0].style.border='';", element);
            js.executeScript("arguments[0].style.backgroundColor='';",element);
        }catch (Exception e){

        }
    }
}
