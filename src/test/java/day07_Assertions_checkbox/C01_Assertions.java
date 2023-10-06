package day07_Assertions_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
asagidaki testleri yapin
○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
○ logoTest => BestBuy logosunun görüntülendigini test edin
○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void TestURL(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrlElement=driver.getCurrentUrl();
        System.out.println(actualUrlElement);
        String expectedUrlIcerik="https://www.bestbuy.com/";
        Assert.assertEquals("Url 'https://www.bestbuy.com/' eşit değil",actualUrlElement,expectedUrlIcerik);
    }
    @Test
    public void testTitle(){
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitleYazi= driver.getTitle();
        System.out.println(actualTitleYazi);
        String unexpectedTitleIcerik="Rest";
        Assert.assertFalse("Başlık 'Rest' içeriyor",actualTitleYazi.contains(unexpectedTitleIcerik));
    }
    @Test
    public  void testBestBuyLogo(){
        WebElement bestBuyLogoElementi= driver.findElement(By.xpath("//*[@class=\"logo\"][1]"));
        Assert.assertTrue("Best Buy Logosu görünmüyor", bestBuyLogoElementi.isDisplayed());
    }
    @Test
    public void testFransizcaLink(){
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini,clicklendiğini ve bonjur yazısının
        // göründüğünü test edin
        driver.findElement(By.xpath("//button[text()=\"Français\"]")).click();
        WebElement bonjurYaziElementi= driver.findElement(By.xpath("//div[text()=\"Bonjour!\"]"));
        Assert.assertTrue("Francais Linki görüntülenmiyor",bonjurYaziElementi.isDisplayed());

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }


}
