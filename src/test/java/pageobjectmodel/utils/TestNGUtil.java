package pageobjectmodel.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestNGUtil {

    protected WebDriver driver;

    @BeforeTest
    public void initBrowser(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
}
