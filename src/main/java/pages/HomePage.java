package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final By kontaktButton = By.xpath("//*[@id='menu-item-760']//child::*[contains(text(),'Kontakt')]");
    private final By wirUberUnsTab = By.xpath("//*[@id='menu-item-54']//child::*[contains(text(),'Wir über uns')]");
    private final By allowCoockiesButton= By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By menuLabel = By.id("footermenu1-title");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public KontaktPage clickKontaktButton() {
        driver.findElement(kontaktButton).click();
        return new KontaktPage(driver);
    }
    public void allowCoockies(){
        WebElement cookieButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(allowCoockiesButton));
        driver.findElement(allowCoockiesButton).click();
    }
    public WirUberUns openWirUberUnsTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(menuLabel);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        WebElement cookieButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(wirUberUnsTab));
        driver.findElement(wirUberUnsTab).click();
        return new WirUberUns(driver);
    }
    public HomePage checkOnPage() {
        Assertions.assertEquals("My Store", driver.getTitle(), "This is not Home Page" +
                " current page is: " + driver.getCurrentUrl());
        return this;
    }
}
