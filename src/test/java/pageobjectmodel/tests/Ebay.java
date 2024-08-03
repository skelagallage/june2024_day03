package pageobjectmodel.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.pages.PageBase;
import pageobjectmodel.pages.PageClothResults;
import pageobjectmodel.pages.PageEbayHome;
import pageobjectmodel.pages.PageMobileResults;
import pageobjectmodel.utils.BrowserFactory;
import pageobjectmodel.utils.TestNGUtil;

public class Ebay extends TestNGUtil {

    @Test
    public void searchMobile() throws InterruptedException {
        ExtentTest extentTest = extent.createTest("searchMobile");
        extentTest.assignAuthor("Sanath")
                        .assignCategory("Web")
                                .assignDevice("chrome");
        extentTest.log(Status.INFO, "searchMobile test is started");
        try {
            PageBase pageBase = PageFactory.initElements(browserFactory.getDriver(), PageBase.class);
            PageEbayHome pageEbayHome = pageBase.initApp("https://www.ebay.com/");
            pageEbayHome.typeOnSearchField("mobile phone");
            pageEbayHome.selectCategory("Cell Phones & Accessories");
            PageMobileResults pageMobileResults = pageEbayHome.clickOnSearchButton();
            pageMobileResults.scroll(0, 200);
            pageMobileResults.clickOnAppleCheckBox();
            Thread.sleep(3000);
            extentTest.pass("Test is passed");
        }catch (Exception ex){
            extentTest.fail(ex.getMessage());
            ex.printStackTrace();
        }


    }

    @Test
    public void searchTShirt() throws InterruptedException {
        ExtentTest extentTest = extent.createTest("searchTShirt");
        extentTest.assignAuthor("Thameera")
                .assignCategory("Web")
                .assignDevice("chrome");
        try{
            extentTest.log(Status.INFO, "searchMobile test is started");
            PageBase pageBase = PageFactory.initElements(browserFactory.getDriver(), PageBase.class);
            PageEbayHome pageEbayHome = pageBase.initApp("https://www.ebay.com/");
            pageEbayHome.typeOnSearchField("T Shirt");
            pageEbayHome.selectCategory("Clothing, Shoes & Accessories");
            PageClothResults pageClothResults = pageEbayHome.clickOnSearchButton();
            pageClothResults.scroll(0, 300);
            pageClothResults.clickOnAdidasCheckBox();
            Thread.sleep(3000);
            extentTest.pass("Test is passed");
        }catch (Exception ex){
            extentTest.fail(ex.getMessage());
        }

    }


}
