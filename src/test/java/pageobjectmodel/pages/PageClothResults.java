package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageClothResults extends PageBase {

    @FindBy(xpath = "//span[text()='adidas']")
    private WebElement adidasCheckBox;

    public PageClothResults(WebDriver driver) {
        super(driver);
    }

//    public void scroll(int x, int y){
//        new Actions(driver).scrollByAmount(x, y).perform();
//    }

    public void clickOnAdidasCheckBox(){
        adidasCheckBox.click();

    }
}


