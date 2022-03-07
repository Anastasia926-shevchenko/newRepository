package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KontaktPage {
    private final WebDriver driver;
    private final By label = By.xpath("//*[contains(text(),'ANFRAGE SENDEN')]");
    private final By radioBewerben = By.xpath("//*[@id='bewerbende']//following::*[@for='bewerbende']");
    private final By nameField = By.id("your-name2");
    private final By vornameField = By.id("vorname2");
    private final By emailField = By.id("email2");
    private final By textField = By.id("anmerkungen2");
    private final By sendenButton = By.xpath("$x(//*[@id='contact-form-2']/fieldset/input)");



    public KontaktPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectCheckBox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(label);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(radioBewerben).click();

    }
    public SuccessfullSending sendRequest(String name, String vorname, String email, String text) throws InterruptedException {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(vornameField).sendKeys(vorname);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(textField).sendKeys(text);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("label.fbcheckbox"))).build().perform();
        return new SuccessfullSending(driver);
    }
}