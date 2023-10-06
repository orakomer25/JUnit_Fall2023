package day14_writeExcel_ScreenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_YoutubeArama extends TestBase {
    @Test
    public void test01() {
        //youtube anasayfaya git
        driver.get("https://www.youtube.com");
        //ahmet bulutluoz  için arama yap
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search']"));

        aramaKutusu.click();
        aramaKutusu.sendKeys("Ahmet Bulutluoz"+ Keys.ENTER);
        //bulunan videolardan ilkinin isminde bulut geçtiğini test edin
        WebElement ilkVideoIsmi=driver.findElement(By.xpath("(//a[@id=\"video-title\"])[1]"));
        String expectedIcerik="QA";
        System.out.println(ilkVideoIsmi.getText());
        String actualVideoIsmi=ilkVideoIsmi.getText();
        Assert.assertTrue(actualVideoIsmi.contains(expectedIcerik));
        //ilk videonun fotografını çekin
        ReusableMethods.webElementFotografCek(ilkVideoIsmi,"AhmetYoutube");
        //
    }
}
