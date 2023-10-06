package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlar {
    WebDriver driver =new ChromeDriver();
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void Amazon(){
       setUp();
        driver.get("https://www.amazon.com");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Amazon Testi PASSED");
        }else {
            System.out.println("Amazon Testi FAILD");

        }
        driver.quit();
    }
    @Test
    public void WiseQuarter(){
       setUp();
       driver.get("https://www.wisequarter.com");
       String actualTitle= driver.getTitle();
       String expectedTitleIcerik="Wise";
       if (actualTitle.contains(expectedTitleIcerik)){
           System.out.println("Wise Title Testi PASSED");
       }else {
           System.out.println("Wise Title Testi FAILD");

       }
       driver.close();
    }
    @Test
    public void Youtube(){
        setUp();
        driver.get("https://www.youtube.com");
        String actualTitle= driver.getTitle();
        String unExpectedTitleIcerik="best";
        if (!actualTitle.contains(unExpectedTitleIcerik)){
            System.out.println("Youtube Title Testi PASSED");
        }else {
            System.out.println("Youtube Title Testi FAILD");

        }
        driver.close();
    }
}
