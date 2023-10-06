package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSAlert extends TestBase {


    @Test
    public void jsAlertTesti(){
        //1. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[text()=\"Click for JS Alert\"]")).click();
        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String alertYazi=driver.switchTo().alert().getText();
        String expectedYazi="I am a JS Alert";
        Assert.assertEquals(alertYazi,expectedYazi);
        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();

    }
    @Test
    public void alertTest2(){
        //2.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()=\"Click for JS Confirm\"]")).click();
        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedIcerik="You clicked: Cancel";
        String actualIcerik=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertEquals(actualIcerik,expectedIcerik);

    }
    @Test
    public void alertTest3(){
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()=\"Click for JS Prompt\"]")).click();
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
       String actualResult= driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
       String expectedIcerik="Abdullah";
       Assert.assertTrue(actualResult.contains(expectedIcerik));

    }

}
