package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_keyboardActions extends TestBase {
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Cookies kabul edin
        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]"));
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        Faker faker=new Faker();

       WebElement isimKutusu= driver.findElement(By.xpath("//*[@name=\"firstname\"]"));
       String email=faker.internet().emailAddress();
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB);

            //TAMAMLANACAK
        //5- Kaydol tusuna basalim
    }
}
