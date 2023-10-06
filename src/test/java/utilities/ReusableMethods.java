package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void tumSayfaFotografCek(WebDriver driver, String resimAdi) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);
        String dinamikdosyaYolu = "target/screenShots/" + resimAdi + tarihEtiketi + ".jpg";
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaSS = new File(dinamikdosyaYolu);
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void webElementFotografCek(WebElement webElement, String resimAdi) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);
        String dinamikdosyaYolu = "target/screenShots/" + resimAdi + tarihEtiketi + ".jpg";

        File tumSayfaSS = new File(dinamikdosyaYolu);
        File geciciDosya = webElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
