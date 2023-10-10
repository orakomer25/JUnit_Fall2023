package day09_iframe_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;


public class C02_IFrame extends TestBase {
    @Test
    public void test01() {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        bekle(5);
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameList=driver.findElements(By.tagName("iframe"));
        System.out.println("IFrame Sayısı :"+iFrameList.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iFrameElement= driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/RbSlW8jZFe8\"]"));
        driver.switchTo().frame(iFrameElement);
        driver.findElement(By.xpath("//*[@aria-label=\"Oynat\"]")).click();
        bekle(2);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        // (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe2= driver.findElement(By.xpath("//*[@id=\"a077aa5e\"]"));
        driver.switchTo().frame(iframe2);
        WebElement JMeterMadeEasy=driver.findElement(By.xpath("//*[@href=\"http://www.guru99.com/live-selenium-project.html\"]"));
       //JavascriptExecutor kütüphanesinden obje oluşturup driver i atayalım
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //obje üzerinden scroll özelliğini kullanalım
        jse.executeScript("arguments[0].scrollIntoView(true);", JMeterMadeEasy);
        bekle(5);
        JMeterMadeEasy.click();
        bekle(5);


    }
}
