package pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class PageEbayHome extends PageBase{

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchField;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categorySelector;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    private String selectionCategory;

    private Map<String, Object> resultMap = new HashMap<>();

    {
        resultMap.put("Cell Phones & Accessories",
                PageFactory.initElements(driver, PageMobileResults.class));
        resultMap.put("Clothing, Shoes & Accessories",
                PageFactory.initElements(driver, PageClothResults.class));
    }

    public PageEbayHome(WebDriver driver) {
        super(driver);
    }

    public void typeOnSearchField(String typeValue){
        searchField.sendKeys(typeValue);
    }

    public void selectCategory(String visibleText){
        selectionCategory = visibleText;
        new Select(categorySelector)
                .selectByVisibleText(visibleText);
    }

    public <T> T clickOnSearchButton(){
        searchButton.click();
//        return PageFactory.initElements(driver, PageMobileResults.class);
        return (T) resultMap.get(selectionCategory);
    }

}
