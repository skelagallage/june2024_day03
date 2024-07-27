package odel;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicSearch {

    WebDriver driver;

    @BeforeTest
    public void initBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        /**
         * Page load timeout
         */
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        /**
         * implicit wait
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    }

    @Test
    public void searchHat() throws InterruptedException {
        driver.get("https://odel.lk/home");
        new Actions(driver).
                moveToElement(driver.findElement(By.xpath
                        ("//a[text()='WOMEN'][1]"))).
                perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='Caps & Hats'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='Brands']/parent::button")).click();
        /**
         * Explicit wait
         */
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='ODEL']"))));

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(500))
                                .ignoring(ElementNotInteractableException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='ODEL']"))));

        driver.findElement(By.xpath("//label[text()='ODEL']")).click();
        Thread.sleep(4000);
    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
}
