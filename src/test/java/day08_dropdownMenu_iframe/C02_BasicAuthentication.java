package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // Username    : admin
        //  password     : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement tebrikYazisi=driver.findElement(By.tagName("p"));
        String actualtebrikYazisi=tebrikYazisi.getText();
        String expectedIcerik="Congratulations";
        Assert.assertTrue(actualtebrikYazisi.contains(expectedIcerik));

    }
}
