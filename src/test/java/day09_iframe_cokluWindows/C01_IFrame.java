package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_IFrame extends TestBase {
    @Test
    public void test01() {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iFrameYaziElement= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iFrameYaziElement.isDisplayed());

        // - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe= driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iframe);
        WebElement textBox= driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");
        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement linkText = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkText.isDisplayed());

    }
}
