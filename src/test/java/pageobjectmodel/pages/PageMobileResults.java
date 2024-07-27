package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageMobileResults extends PageBase{

    @FindBy(xpath = "//span[text()='Apple']")
    private WebElement appleCheckBox;

    @FindBy(xpath = "//span[text()='Samsung']")
    private WebElement samsungCheckBox;


    public PageMobileResults(WebDriver driver) {
        super(driver);
    }

    public void clickOnAppleCheckBox(){
        appleCheckBox.click();
    }

//    public void scroll(int x, int y){
//        new Actions(driver).scrollByAmount(x, y).perform();
//    }
}
