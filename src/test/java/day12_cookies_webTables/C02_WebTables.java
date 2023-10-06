package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C02_WebTables extends TestBase {
    @Test
    public void test01() {
        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(3);
        //3.Web table tum body’sini yazdirin
        WebElement tableElement= driver.findElement(By.className("navFooterMoreOnAmazon"));
        System.out.println(tableElement.getText());

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> tableSatirElementleri=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi=7;
        int actualSatirSayisi= tableSatirElementleri.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);
        //5.Tum satirlari yazdirin
        System.out.println("*************TÜM SATIRLAR**************");
        for (int i = 0; i < tableSatirElementleri.size() ; i++) {
            System.out.println((i+1)+" - "+tableSatirElementleri.get(i).getText());

        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin

        //7. 5.sutunu yazdirin
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
    }
}
