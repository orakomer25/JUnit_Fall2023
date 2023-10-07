package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P09 {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        //BeforeClass ile driver'i oluşturun ve class icinde static yapin
        //Maximize edin ve 10 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //http://www.qooqle.com adresine gidin

    }
    @Before
    public void before(){
        driver.get("http://www.google.com");

    }

    @Test
    public void test01() {
        //1-arama kutusuna "12 Angry Men” yaz ip, cikan sonuc şayisini yazdinin
        WebElement aramakutusu=driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        aramakutusu.sendKeys("12 Angry Men"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        System.out.println(sonucYazisi.getText());

    }

    @Test
    public void test02() {
        //2-arama kutusuna "Vizontele” yaz ip, cikan sonuc şayisini yazdirin
        WebElement aramakutusu=driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        aramakutusu.sendKeys("Vizontele"+Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        System.out.println(sonucYazisi.getText());
    }

    @Test
    public void test03() {
        //3-arama kutusuna "Saving Private Ryan” yaz4p, cikan sonuc şayisini yazdirin
        WebElement aramakutusu=driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        aramakutusu.sendKeys("Saving Private Ryan"+Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        System.out.println(sonucYazisi.getText());
    }

    @AfterClass
    public static void afterClass(){
        //AfterClass ile kapatin.
        driver.close();
    }
}
