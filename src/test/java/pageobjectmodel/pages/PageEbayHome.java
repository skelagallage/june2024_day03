package pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageEbayHome extends PageBase{

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchField;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categorySelector;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    public PageEbayHome(WebDriver driver) {
        super(driver);
    }

    public void typeOnSearchField(String typeValue){
        searchField.sendKeys(typeValue);
    }

    public void selectCategory(String visibleText){
        new Select(categorySelector)
                .selectByVisibleText(visibleText);
    }

    public PageMobileResults clickOnSearchButton(){
        searchButton.click();
        return PageFactory.initElements(driver, PageMobileResults.class);
    }

}
