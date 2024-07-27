package pageobjectmodel.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestNGUtil {

//    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void initBrowser(@Optional("chrome") String browser){
        System.setProperty("browser", browser);
//        driver = WebDriverManager.chromedriver().create();
        BrowserFactory.getBrowserFactory().getDriver().manage().window().maximize();
    }

    @AfterTest
    public void quitBrowser(){
        BrowserFactory.getBrowserFactory().getDriver().quit();
    }
}
