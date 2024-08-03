package pageobjectmodel.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestNGUtil {

//    protected WebDriver driver;
    protected BrowserFactory browserFactory;
    protected ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("report/Spark.html");



    @BeforeTest
    @Parameters("browser")
    public void initBrowser(@Optional("chrome") String browser){
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Ebay Report");
        System.setProperty("browser", browser);
//        driver = WebDriverManager.chromedriver().create();
        browserFactory = BrowserFactory.getBrowserFactory();
    }

    @AfterTest
    public void quitBrowser(){
        browserFactory.quitDriver();
        extent.attachReporter(spark);
        extent.flush();
    }
}
