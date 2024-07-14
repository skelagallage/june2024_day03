package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public PageEbayHome initApp(String url){
        driver.get(url);
        return PageFactory.initElements(driver,
                PageEbayHome.class);
    }
}
