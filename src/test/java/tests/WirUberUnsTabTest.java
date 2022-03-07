package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.WirUberUns;
import utils.PropertyReader;

public class WirUberUnsTabTest extends WebDriverFactory{

    @Test
    public void test() {
        driver.get(PropertyReader.BASEURL);
        HomePage homePage = new HomePage(driver);
        homePage.allowCoockies();
        WirUberUns wirUberUns;
        wirUberUns = homePage.openWirUberUnsTab();
        wirUberUns.checkOnPage();
        wirUberUns.selectHamburg();
        wirUberUns.moveBetweenPictures();
        wirUberUns.closeHamburg();
        wirUberUns.openKarteMode();
        wirUberUns.selectKompetenzOption();
        wirUberUns.selectAgileWorkingMethodTab();
    }
}