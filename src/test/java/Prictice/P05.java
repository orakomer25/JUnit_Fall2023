package Prictice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P05 extends TestBase {

    @Test
    public void test01() {


        //5-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.get("http://www.babayigit.net/murat/testpage.html");
        //6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        //    alanlarına gerekli bilgileri yazsın
        driver.findElement(By.id("ad")).sendKeys("ömer");
        driver.findElement(By.id("soyad")).sendKeys("orak");
        driver.findElement(By.id("yas")).sendKeys("37");
        driver.findElement(By.id("meslek")).sendKeys("subay");
        driver.findElement(By.id("dogum_yeri")).sendKeys("Erzurum");
        driver.findElement(By.id("mezun_okul")).sendKeys("ATAUNİ");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("1");
        //7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        //8- All information was entered correctly.. yazısının göründüğünü test etsin
        WebElement yaziElementi= driver.findElement(By.xpath("//p[@id=\"uyari\"]"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        //9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//*[@type=\"reset\"]")).click();
        //10- Manuel olarak temizlendiğini görecek kadar beklesin
        bekle(3);
        //11- Sayfayı kapatsın
        //10-8. maddededeki Test sonucunu yazdırsın
        if (yaziElementi.isDisplayed()){
            System.out.println("yazi testi PASSED");
        }else {
            System.out.println("yazi testi FAILD");
        }

    }


}
