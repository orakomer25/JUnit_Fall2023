package Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P10 extends TestBase {

    @Test
    public void test01() {

// Kullanici https://www.google.com adresine gider
        driver.get("https://www.google.com");
// Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
        WebElement aramakutusu=driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        aramakutusu.sendKeys("USD TO TRY"+ Keys.ENTER);
// Para birimlerinin karsilastirmasini alin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class=\"DFlfde SwHCTb\"]"));
        String result=sonucYazisi.getText().replace(",",".");
        double resultDouble=Double.parseDouble(result);
        // Karsilastirilacak olan para biriminin 25 den kUCUk oldygu test edilir
        Assert.assertTrue("imkansız olamaz",resultDouble>25);

    }
}
