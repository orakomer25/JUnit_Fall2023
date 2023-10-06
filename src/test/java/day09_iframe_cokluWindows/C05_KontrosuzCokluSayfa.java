package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C05_KontrosuzCokluSayfa extends TestBase {
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe url'ine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaWHD= driver.getWindowHandle();
        // sayfa basliginin Internet icerdigini test edin
        String actualTitle= driver.getTitle();
        String expectedTitleIcerik="Internet";
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Elemental Selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // Yeni acilan tab'in Title'inin Selenium icerdigini test edin
        String ikinciSayfaWHD="";
        Set<String> whdSeti=driver.getWindowHandles();
        for (String each:whdSeti
             ) {if (!each.equals(ilkSayfaWHD)){
                 ikinciSayfaWHD=each;
        }

        }
        driver.switchTo().window(ikinciSayfaWHD);
        expectedTitleIcerik="Selenium";
        actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        // Ilk sayfaya donup url'in internet icerdigini test edin
        driver.switchTo().window(ilkSayfaWHD);
        String ilkSayfaUrl= driver.getCurrentUrl();
        String expectedUrlIcerik="internet";
        Assert.assertTrue(ilkSayfaUrl.contains(expectedUrlIcerik));
    }
}
