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

import java.time.Duration;

public class C03_checkBox {
    /*
    a. Verilen web sayfasına gidin.
     https://the-internet.herokuapp.com/checkboxes
 b. Checkbox1 ve checkbox2 elementlerini locate edin.
 c. Checkbox1 seçili değilse onay kutusunu tıklayın
 d. Checkbox2 seçili değilse onay kutusunu tıklayın
 e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void facebookTest(){
        //Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        // Checkbox1 seçili değilse onay kutusunu tıklayın
        //Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        //Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checkbox1.isSelected()&&checkbox2.isSelected());




    }
}
