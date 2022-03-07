package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WirUberUns {
    private final WebDriver driver;
    private final By hamburgButton = By.xpath("//*[@class='btn btn-city btn-hamburg active']");
    private final By arrow = By.xpath("//*[@class='swiper-button-next swiper-button-white']");
    private final By closeButton = By.xpath("//*[@class='btn-close-swiper']");
    private final By karteButton = By.xpath("//*[@class='maptype-control-btn maptype-control-map active']");
    private final By kompetenzButton = By.xpath("//*[@class='btn btn-red collapsed' and contains(text(),'KOMPETENZ')]");
    private final By releaseDemobutton = By.xpath("//*[@class='title-btn title-btn-1']");
    private final By unsereStandorteTab = By.xpath("//*[@class='title__general']");
    private final By wasUnsAusmachtTab = By.xpath("//*[@class='title title-blue']//child::*[contains(text(),'WAS UNS AUSMACHT')]");
    private final By agileWorkingMethodTab = By.xpath("//*[@class='title title-blue']//child::*[contains(text(),'AGILE WORKING METHOD')]");
    private final By pageLabel = By.xpath("//span[contains(text(),'Wir über uns')]");
    private final By textPath = By.xpath("//*[@id='collapse3']//child::*[contains(text(),'20 Jahre über 250 abgeschlossene')]");
    private final By releaseDemoText = By.xpath("//*[@class='desc desc-1 show']//child::*[contains(text(),'Nach einem Program Increment (PI)')]");



    public WirUberUns(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOnPage() {
        Assertions.assertTrue(driver.findElement(pageLabel).isDisplayed());
    }



    public void selectHamburg() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(unsereStandorteTab);
        js.executeScript("arguments[0].scrollIntoView();", Element);
       // WebElement cookieButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(hamburgButton));
        driver.findElement(hamburgButton).click();
        Assertions.assertTrue(driver.findElement(arrow).isDisplayed());
    }

    public void moveBetweenPictures() {
        driver.findElement(arrow).click();
    }

    public void closeHamburg() {
        driver.findElement(closeButton).click();
        Assertions.assertTrue(driver.findElement(wasUnsAusmachtTab).isDisplayed());
    }

    public void openKarteMode() {
        driver.findElement(karteButton).click();
    }

    public void selectKompetenzOption() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(wasUnsAusmachtTab);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(kompetenzButton).click();
        Assertions.assertTrue(driver.findElement(textPath).isDisplayed());
    }
    public void selectAgileWorkingMethodTab(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(agileWorkingMethodTab);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(releaseDemobutton).click();
        Assertions.assertTrue(driver.findElement(releaseDemoText).isDisplayed());
    }
}