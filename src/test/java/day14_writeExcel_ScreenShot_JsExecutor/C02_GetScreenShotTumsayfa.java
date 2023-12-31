package day14_writeExcel_ScreenShot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_GetScreenShotTumsayfa extends TestBase {
    @Test
    public void test01() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // Sonuclarin Nutella icerdigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedIcerik ="Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        // rapor icin sayfanin fotografini cekin
        // 1.adim TakeScreenshot objesi olusturma
        TakesScreenshot tss = (TakesScreenshot) driver;
        // 2.adim fotografi kaydedecegimiz dosyayi olusturalim, dosya yolunu yazalim
        File tumSayfaScreenshot = new File("target/screenShots/tumSayfaScreenshot.png");
        // 3.adim bir gecici dosya olusturup buna tss objesi ile cektigimiz fotografi kaydedelim
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        // 4.adim gecici resmi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,tumSayfaScreenshot);
        bekle(5);
    }
    public static void tumSayfaFotografCek(WebDriver driver,String resimAdi){
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi=ldt.format(formatter);
        String dinamikdosyaYolu="target/screenShots/"+resimAdi+tarihEtiketi+".jpg";
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaSS=new File(dinamikdosyaYolu);
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
